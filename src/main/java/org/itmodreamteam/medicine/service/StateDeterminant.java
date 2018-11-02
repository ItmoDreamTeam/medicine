package org.itmodreamteam.medicine.service;

import org.itmodreamteam.medicine.model.Measurement;
import org.itmodreamteam.medicine.model.State;

/**
 * Next state of medical process is determined by measurements (whether the patient feels better or worse).
 * Only several most significant measurements are considered when changing state of a typical medical process.
 * State may remain the same if the measurements haven't changed much (certainly, number of self-iterations is limited).
 */
public class StateDeterminant {

    public static State determineNextState(State currentState, Measurement measurement) {
        return new State();
    }
}
