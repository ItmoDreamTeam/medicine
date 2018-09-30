package org.itmodreamteam.medicine.data;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.model.patient.CaseHistory;
import org.itmodreamteam.medicine.model.patient.Patient;
import org.itmodreamteam.medicine.repository.CaseHistoryRepository;
import org.itmodreamteam.medicine.repository.PatientRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.itmodreamteam.medicine.util.ReadableStringGenerator.generateName;

@Component
@RequiredArgsConstructor
public class PatientGenerator {

    private static final int PATIENTS_QUANTITY = 3;

    private final CaseHistoryRepository caseHistoryRepository;
    private final PatientRepository patientRepository;

    public void generatePatientsAndCaseHistories() {
        Random random = ThreadLocalRandom.current();
        for (int i = 0; i < PATIENTS_QUANTITY; ++i) {
            Patient patient = patientRepository.save(new Patient(generateName(1)));
            LocalDateTime admissionDateTime = LocalDateTime.of(2018, Month.SEPTEMBER, random.nextInt(30) + 1, 8, 0);
            caseHistoryRepository.save(new CaseHistory(patient, admissionDateTime));
        }
    }
}
