package org.itmodreamteam.medicine.service;

public interface MedicalProcessFactory {

    TreatmentDeterminant getTreatmentDeterminant();

    NextStateDeterminant getNextStateDeterminant();
}
