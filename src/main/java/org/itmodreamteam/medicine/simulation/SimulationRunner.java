package org.itmodreamteam.medicine.simulation;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.data.DiseaseGenerator;
import org.itmodreamteam.medicine.data.PatientGenerator;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimulationRunner implements ApplicationRunner {

    private final DiseaseGenerator diseaseGenerator;
    private final PatientGenerator patientGenerator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        generateData();
    }

    private void generateData() {
        diseaseGenerator.generateMeasurementsDiseasesAndTreatments();
        patientGenerator.generatePatientsAndCaseHistories();
    }
}
