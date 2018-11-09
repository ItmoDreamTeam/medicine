package org.itmodreamteam.medicine.repository;

import org.itmodreamteam.medicine.model.MedicalProcess;
import org.springframework.stereotype.Repository;

import static org.itmodreamteam.medicine.repository.StateRepository.STATE1;
import static org.itmodreamteam.medicine.repository.StateRepository.STATE4;

@Repository
public class MedicalProcessRepository {

    public MedicalProcess get(long id) {
        return new MedicalProcess(id, STATE1, STATE4);
    }
}
