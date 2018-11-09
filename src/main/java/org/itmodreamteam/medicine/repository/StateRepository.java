package org.itmodreamteam.medicine.repository;

import org.itmodreamteam.medicine.model.MedicalProcess;
import org.itmodreamteam.medicine.model.State;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class StateRepository {

    static final State STATE1 = new State(1, Arrays.asList());
    static final State STATE4 = new State(4, Arrays.asList());

    public State get(MedicalProcess medicalProcess, long id) {
        if (id == 1) {
            return STATE1;
        }
        if (id == 4) {
            return STATE4;
        }
        throw new IllegalStateException();
    }
}
