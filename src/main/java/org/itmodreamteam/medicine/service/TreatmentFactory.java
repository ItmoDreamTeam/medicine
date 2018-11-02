package org.itmodreamteam.medicine.service;

import org.itmodreamteam.medicine.model.State;
import org.itmodreamteam.medicine.model.Treatment;

public class TreatmentFactory {

    public static Treatment getTreatment(State state) {
        return new Treatment();
    }
}
