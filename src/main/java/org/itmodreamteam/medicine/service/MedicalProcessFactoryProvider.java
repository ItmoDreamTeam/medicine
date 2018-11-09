package org.itmodreamteam.medicine.service;

import org.itmodreamteam.medicine.model.MedicalProcess;
import org.itmodreamteam.medicine.model.State;

public class MedicalProcessFactoryProvider {

    public static MedicalProcessFactory provide(MedicalProcess medicalProcess, State state) {
        if (medicalProcess.getId() == 37145) {
            if (state.getId() == 1) {
                return new BronchialAsthmaState1MedicalProcessFactory();
            }
        }
        throw new IllegalStateException();
    }
}
