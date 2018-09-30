package org.itmodreamteam.medicine.data;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataGenerator implements ApplicationRunner {

    private final DiseaseGenerator diseaseGenerator;
    private final PatientGenerator patientGenerator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        diseaseGenerator.generateMeasurementsDiseasesAndTreatments();
        patientGenerator.generatePatientsAndCaseHistories();
    }
}
