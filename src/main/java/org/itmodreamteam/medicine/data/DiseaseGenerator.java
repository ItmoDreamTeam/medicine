package org.itmodreamteam.medicine.data;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.model.disease.*;
import org.itmodreamteam.medicine.repository.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.itmodreamteam.medicine.util.ReadableStringGenerator.generateName;

@Component
@RequiredArgsConstructor
public class DiseaseGenerator {

    private static final int DISEASES_QUANTITY = 10;
    private static final int MEASUREMENTS_QUANTITY = 100;
    private static final int TREATMENTS_QUANTITY = 1000;

    private final DiseaseRepository diseaseRepository;
    private final MeasurementRepository measurementRepository;
    private final TreatmentRepository treatmentRepository;
    private final DiseaseMeasurementRepository diseaseMeasurementRepository;
    private final DiseaseTreatmentRepository diseaseTreatmentRepository;

    public void generateMeasurementsDiseasesAndTreatments() {
        generateMeasurements();
        generateDiseases();
        generateTreatments();
        generateMeasurementsForDiseases();
        generateTreatmentsForDiseases();
    }

    public void generateTreatments() {
        for (int i = 0; i < TREATMENTS_QUANTITY; ++i) {
            treatmentRepository.save(new Treatment(generateName(1)));
        }
    }

    public void generateMeasurements() {
        for (int i = 0; i < MEASUREMENTS_QUANTITY; ++i) {
            measurementRepository.save(new Measurement(generateName(1)));
        }
    }

    public void generateDiseases() {
        for (int i = 0; i < DISEASES_QUANTITY; ++i) {
            diseaseRepository.save(new Disease(generateName(1)));
        }
    }

    public void generateMeasurementsForDiseases() {
        diseaseRepository.findAll().parallelStream().forEach(this::generateMeasurementsForDisease);
    }

    public void generateTreatmentsForDiseases() {
        diseaseRepository.findAll().parallelStream().forEach(this::generateTreatmentsForDisease);
    }

    public void generateMeasurementsForDisease(Disease disease) {
        Random random = ThreadLocalRandom.current();
        int measurementsCount = random.nextInt(MEASUREMENTS_QUANTITY / 5) + 5;
        fetchRandomMeasurements(measurementsCount).parallelStream()
                .map(measurement -> {
                    double value1 = random.nextDouble();
                    double value2 = random.nextDouble();
                    if (value1 > value2) {
                        double tmp = value1;
                        value1 = value2;
                        value2 = tmp;
                    }
                    return new DiseaseMeasurement(disease, measurement, value1, value2);
                })
                .forEach(diseaseMeasurementRepository::save);
    }

    public void generateTreatmentsForDisease(Disease disease) {
        Random random = ThreadLocalRandom.current();
        int treatmentsCount = random.nextInt(TREATMENTS_QUANTITY / 4) + 10;
        fetchRandomTreatments(treatmentsCount).parallelStream()
                .map(treatment -> new DiseaseTreatment(disease, treatment, random.nextInt(100)))
                .forEach(diseaseTreatmentRepository::save);
    }

    private List<Measurement> fetchRandomMeasurements(int count) {
        List<Measurement> measurements = measurementRepository.findAll();
        Collections.shuffle(measurements);
        return measurements.subList(0, count);
    }

    private List<Treatment> fetchRandomTreatments(int count) {
        List<Treatment> treatments = treatmentRepository.findAll();
        Collections.shuffle(treatments);
        return treatments.subList(0, count);
    }
}
