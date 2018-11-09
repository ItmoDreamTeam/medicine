package org.itmodreamteam.medicine.service;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.model.CaseHistory;
import org.itmodreamteam.medicine.model.Measurement;
import org.itmodreamteam.medicine.model.State;
import org.itmodreamteam.medicine.repository.MeasurementRepository;
import org.itmodreamteam.medicine.repository.StateRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BronchialAsthmaState1NextStateDeterminant implements NextStateDeterminant {

    private final MeasurementRepository measurementRepository;
    private final StateRepository stateRepository;

    @Override
    public State determineNextState(CaseHistory caseHistory) {
        Measurement pefMeasurement = measurementRepository.getRelevantMeasurement(caseHistory.getPatient(), 317);
        double pefValue = pefMeasurement.getDoubleValue();
        if (pefValue > 80) {
            return stateRepository.get(caseHistory.getMedicalProcess(), 2);
        }
        if (pefValue < 60) {
            return stateRepository.get(caseHistory.getMedicalProcess(), 4);
        }
        return stateRepository.get(caseHistory.getMedicalProcess(), 3);
    }
}
