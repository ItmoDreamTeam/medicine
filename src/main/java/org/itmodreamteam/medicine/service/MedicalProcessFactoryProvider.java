package org.itmodreamteam.medicine.service;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.model.MedicalProcess;
import org.itmodreamteam.medicine.model.State;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MedicalProcessFactoryProvider {

    private final BronchialAsthmaState1MedicalProcessFactory bronchialAsthmaState1MedicalProcessFactory;

    public MedicalProcessFactory provide(MedicalProcess medicalProcess, State state) {
        if (medicalProcess.getId() == 37145) {
            if (state.getId() == 1) {
                return bronchialAsthmaState1MedicalProcessFactory;
            }
        }
        throw new IllegalStateException();
    }
}
