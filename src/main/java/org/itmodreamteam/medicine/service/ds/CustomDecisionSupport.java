package org.itmodreamteam.medicine.service.ds;

import org.itmodreamteam.medicine.model.Measurement;
import org.itmodreamteam.medicine.model.TreatmentDefinition;
import org.springframework.stereotype.Component;

@Component
public class CustomDecisionSupport implements DecisionSupport {

    @Override
    public boolean isCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2) {
        return true;
    }

    @Override
    public boolean isCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2, Measurement measurement) {
        return true;
    }
}
