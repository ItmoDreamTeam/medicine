package org.itmodreamteam.medicine.repository;

import org.itmodreamteam.medicine.model.CaseHistory;
import org.itmodreamteam.medicine.model.MedicalProcess;
import org.itmodreamteam.medicine.model.Patient;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class CaseHistoryRepository {

    public CaseHistory create(Patient patient, MedicalProcess medicalProcess) {
        return new CaseHistory(patient, medicalProcess, medicalProcess.getInitialState(), LocalDateTime.now(), null);
    }
}
