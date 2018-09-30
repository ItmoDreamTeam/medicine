package org.itmodreamteam.medicine.simulation.step;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.itmodreamteam.medicine.model.disease.Measurement;
import org.itmodreamteam.medicine.model.patient.PatientMeasurement;
import org.itmodreamteam.medicine.repository.MeasurementRepository;
import org.itmodreamteam.medicine.repository.PatientMeasurementRepository;
import org.itmodreamteam.medicine.simulation.PatientCaseHistory;
import org.itmodreamteam.medicine.simulation.Step;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class MeasurementStepRunner implements StepRunner {

    private static final int REQUIRED_HEALTHY_MEASUREMENTS_PERCENTAGE = 20;

    private final MeasurementRepository measurementRepository;
    private final PatientMeasurementRepository patientMeasurementRepository;

    @Override
    public void run(PatientCaseHistory history) {
        if (isHealthy(history)) {
            history.setStep(Step.DISCHARGE);
        } else {
            takeMeasurements(history);
            history.setStep(Step.DIAGNOSE);
        }
    }

    private boolean isHealthy(PatientCaseHistory history) {
        double takenMeasurementsPercentage = 100.0 * history.getMeasurements().size() / measurementRepository.count();
        return takenMeasurementsPercentage >= REQUIRED_HEALTHY_MEASUREMENTS_PERCENTAGE &&
                history.getMeasurements().parallelStream().allMatch(measurement -> measurement.getValue() < 0.1);
    }

    private void takeMeasurements(PatientCaseHistory history) {
        Random random = ThreadLocalRandom.current();
        List<Measurement> measurements = getNotTakenMeasurements(history, random.nextInt(10) + 1);
        measurements.forEach(measurement -> takeMeasurement(history, measurement));
        log.info("{} -> {} measurements taken", history.getPatient().getName(), measurements.size());
    }

    private List<Measurement> getNotTakenMeasurements(PatientCaseHistory history, int limit) {
        List<Measurement> takenMeasurements = history.getMeasurements().parallelStream()
                .map(PatientMeasurement::getMeasurement)
                .collect(Collectors.toList());
        List<Measurement> notTakenMeasurements = measurementRepository.findAll().parallelStream()
                .filter(measurement -> !takenMeasurements.contains(measurement))
                .collect(Collectors.toList());
        Collections.shuffle(notTakenMeasurements);
        return notTakenMeasurements.stream().limit(limit).collect(Collectors.toList());
    }

    private void takeMeasurement(PatientCaseHistory history, Measurement measurement) {
        Random random = ThreadLocalRandom.current();
        double value = random.nextDouble();
        PatientMeasurement patientMeasurement = new PatientMeasurement(history.getCaseHistory(), measurement, LocalDateTime.now(), value);
        patientMeasurement = patientMeasurementRepository.save(patientMeasurement);
        history.addPatientMeasurement(patientMeasurement);
    }
}
