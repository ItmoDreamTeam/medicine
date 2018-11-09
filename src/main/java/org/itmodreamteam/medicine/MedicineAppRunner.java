package org.itmodreamteam.medicine;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.model.CaseHistory;
import org.itmodreamteam.medicine.model.MedicalProcess;
import org.itmodreamteam.medicine.model.Patient;
import org.itmodreamteam.medicine.repository.CaseHistoryRepository;
import org.itmodreamteam.medicine.repository.MedicalProcessRepository;
import org.itmodreamteam.medicine.repository.PatientRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MedicineAppRunner implements ApplicationRunner {

    private final PatientRepository patientRepository;
    private final MedicalProcessRepository medicalProcessRepository;
    private final CaseHistoryRepository caseHistoryRepository;
    private final AutomatonRunner automatonRunner;

    @Override
    public void run(ApplicationArguments args) {
        Patient patient = patientRepository.get(2549);
        MedicalProcess medicalProcess = medicalProcessRepository.get(37145);
        CaseHistory caseHistory = caseHistoryRepository.create(patient, medicalProcess);
        automatonRunner.run(caseHistory);
    }
}
