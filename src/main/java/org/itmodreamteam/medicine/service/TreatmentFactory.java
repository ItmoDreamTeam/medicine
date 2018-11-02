package org.itmodreamteam.medicine.service;

import org.itmodreamteam.medicine.model.Measurement;
import org.itmodreamteam.medicine.model.State;
import org.itmodreamteam.medicine.model.Treatment;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The more measurements we have taken (the more factors we have considered),
 * the better treatment we will choose to cure the patient
 */
public class TreatmentFactory {

    public static Treatment getTreatment(State state, Measurement measurement) {
        List<Treatment> treatments = state.getTreatments();
        return treatments.get(ThreadLocalRandom.current().nextInt(treatments.size()));
    }
}
