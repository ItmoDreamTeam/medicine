package org.itmodreamteam.medicine.service;

public class BronchialAsthmaState1MedicalProcessFactory implements MedicalProcessFactory {

    @Override
    public TreatmentDeterminant getTreatmentDeterminant() {
        return new BronchialAsthmaState1TreatmentDeterminant();
    }

    @Override
    public NextStateDeterminant getNextStateDeterminant() {
        return new BronchialAsthmaState1NextStateDeterminant();
    }
}
