package org.itmodreamteam.medicine.service.ds;

import org.itmodreamteam.medicine.model.MeasurementDefinition;
import org.itmodreamteam.medicine.model.TreatmentDefinition;

public class CustomDecisionSupport implements DecisionSupport {

    @Override
    public boolean isCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2) {
        return true;
    }

    @Override
    public boolean isCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2, MeasurementDefinition measurement) {
        return true;
    }
}
