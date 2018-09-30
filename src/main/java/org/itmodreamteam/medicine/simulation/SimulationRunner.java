package org.itmodreamteam.medicine.simulation;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.data.DiseaseGenerator;
import org.itmodreamteam.medicine.data.PatientGenerator;
import org.itmodreamteam.medicine.repository.CaseHistoryRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimulationRunner implements ApplicationRunner {

    private final DiseaseGenerator diseaseGenerator;
    private final PatientGenerator patientGenerator;
    private final CaseHistoryRepository caseHistoryRepository;
    private final HealLoopRunner healLoopRunner;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        generateData();
        caseHistoryRepository.findAll().stream()
                .map(PatientCaseHistory::new)
                .forEach(healLoopRunner::heal);
    }

    private void generateData() {
        diseaseGenerator.generateMeasurementsDiseasesAndTreatments();
        patientGenerator.generatePatientsAndCaseHistories();
    }
}
