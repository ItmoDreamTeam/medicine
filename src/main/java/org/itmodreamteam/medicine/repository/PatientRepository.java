package org.itmodreamteam.medicine.repository;

import org.itmodreamteam.medicine.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepository {

    public Patient get(long id) {
        return new Patient();
    }
}
