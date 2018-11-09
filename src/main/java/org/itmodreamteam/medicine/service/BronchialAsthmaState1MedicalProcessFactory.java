package org.itmodreamteam.medicine.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BronchialAsthmaState1MedicalProcessFactory implements MedicalProcessFactory {

    private final BronchialAsthmaState1NextStateDeterminant bronchialAsthmaState1NextStateDeterminant;
    private final BronchialAsthmaState1TreatmentDeterminant bronchialAsthmaState1TreatmentDeterminant;

    @Override
    public TreatmentDeterminant getTreatmentDeterminant() {
        return bronchialAsthmaState1TreatmentDeterminant;
    }

    @Override
    public NextStateDeterminant getNextStateDeterminant() {
        return bronchialAsthmaState1NextStateDeterminant;
    }
}
