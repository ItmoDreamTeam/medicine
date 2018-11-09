package org.itmodreamteam.medicine.service;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.model.CaseHistory;
import org.itmodreamteam.medicine.model.Measurement;
import org.itmodreamteam.medicine.model.TreatmentDefinition;
import org.itmodreamteam.medicine.repository.MeasurementRepository;
import org.itmodreamteam.medicine.repository.TreatmentDefinitionRepository;
import org.itmodreamteam.medicine.service.ds.DecisionSupportAggregator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BronchialAsthmaState1TreatmentDeterminant implements TreatmentDeterminant {

    private final DecisionSupportAggregator decisionSupportAggregator;
    private final MeasurementRepository measurementRepository;
    private final TreatmentDefinitionRepository treatmentDefinitionRepository;

    @Override
    public List<TreatmentDefinition> determineTreatments(CaseHistory caseHistory) {
        return caseHistory.getCurrentState().getTreatments().stream()
                .filter(potentialTreatment -> isCompatible(caseHistory, potentialTreatment))
                .collect(Collectors.toList());
    }

    private boolean isCompatible(CaseHistory caseHistory, TreatmentDefinition potentialTreatment) {
        for (TreatmentDefinition currentTreatment : treatmentDefinitionRepository.getCurrentTreatments(caseHistory.getPatient())) {
            if (!decisionSupportAggregator.isCompatible(potentialTreatment, currentTreatment)) {
                return false;
            }
            for (Measurement significantMeasurement : measurementRepository.getSignificantMeasurements(caseHistory.getPatient())) {
                if (!decisionSupportAggregator.isCompatible(potentialTreatment, currentTreatment, significantMeasurement)) {
                    return false;
                }
            }
        }
        return true;
    }
}
