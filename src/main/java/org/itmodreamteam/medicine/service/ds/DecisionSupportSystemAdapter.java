package org.itmodreamteam.medicine.service.ds;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.model.Measurement;
import org.itmodreamteam.medicine.model.TreatmentDefinition;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DecisionSupportSystemAdapter implements DecisionSupport {

    private final DecisionSupportSystem decisionSupportSystem;

    @Override
    public boolean isCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2) {
        return decisionSupportSystem.dssIsCompatible(treatment1, treatment2);
    }

    @Override
    public boolean isCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2, Measurement measurement) {
        return decisionSupportSystem.dssIsCompatible(treatment1, treatment2, measurement);
    }
}
