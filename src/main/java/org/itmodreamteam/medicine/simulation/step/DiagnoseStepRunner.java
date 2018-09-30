package org.itmodreamteam.medicine.simulation.step;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.itmodreamteam.medicine.model.disease.Disease;
import org.itmodreamteam.medicine.model.disease.DiseaseMeasurement;
import org.itmodreamteam.medicine.model.patient.PatientMeasurement;
import org.itmodreamteam.medicine.repository.DiseaseMeasurementRepository;
import org.itmodreamteam.medicine.repository.DiseaseRepository;
import org.itmodreamteam.medicine.simulation.PatientCaseHistory;
import org.itmodreamteam.medicine.simulation.Step;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class DiagnoseStepRunner implements StepRunner {

    private final DiseaseRepository diseaseRepository;
    private final DiseaseMeasurementRepository diseaseMeasurementRepository;

    @Override
    public void run(PatientCaseHistory history) {
        Optional<Disease> disease = diagnose(history);
        if (disease.isPresent()) {
            history.setDisease(disease.get());
            history.setStep(Step.TREATMENT);
            log.info("{} -> diagnose made: {}", history.getPatient().getName(), disease.get().getName());
        } else {
            history.setStep(Step.MEASUREMENT);
            log.info("{} -> diagnose NOT made", history.getPatient().getName());
        }
    }

    private Optional<Disease> diagnose(PatientCaseHistory history) {
        double minDistance = Double.MAX_VALUE;
        Disease probableDisease = null;
        for (Disease disease : diseaseRepository.findAll()) {
            double distance = distance(diseaseMeasurementRepository.findAllByDisease(disease), history.getMeasurements());
            if (distance < minDistance) {
                minDistance = distance;
                probableDisease = disease;
            }
        }
        log.info("min distance = {}", minDistance);
        return minDistance < 7 ? Optional.of(probableDisease) : Optional.empty();
    }

    private double distance(List<DiseaseMeasurement> diseaseMeasurements, List<PatientMeasurement> patientMeasurements) {
        double distance = 0;
        for (DiseaseMeasurement diseaseMeasurement : diseaseMeasurements) {
            Optional<PatientMeasurement> patientMeasurement = patientMeasurements.parallelStream()
                    .filter(pm -> pm.getMeasurement().equals(diseaseMeasurement.getMeasurement()))
                    .findAny();
            if (patientMeasurement.isPresent()) {
                double value = patientMeasurement.get().getValue();
                if (diseaseMeasurement.getValueFrom() > value || diseaseMeasurement.getValueTo() < value) {
                    distance += 1;
                }
            } else {
                distance += 1;
            }
        }
        return distance;
    }
}
