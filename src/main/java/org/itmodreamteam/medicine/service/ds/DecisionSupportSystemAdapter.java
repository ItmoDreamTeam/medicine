package org.itmodreamteam.medicine.service.ds;

import org.itmodreamteam.medicine.model.MeasurementDefinition;
import org.itmodreamteam.medicine.model.TreatmentDefinition;

public class DecisionSupportSystemAdapter implements DecisionSupport {

    private final DecisionSupportSystem decisionSupportSystem = new DecisionSupportSystem();

    @Override
    public boolean isCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2) {
        return decisionSupportSystem.dssIsCompatible(treatment1, treatment2);
    }

    @Override
    public boolean isCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2, MeasurementDefinition measurement) {
        return decisionSupportSystem.dssIsCompatible(treatment1, treatment2, measurement);
    }
}
