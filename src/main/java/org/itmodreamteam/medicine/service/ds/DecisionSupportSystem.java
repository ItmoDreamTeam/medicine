package org.itmodreamteam.medicine.service.ds;

import org.itmodreamteam.medicine.model.Measurement;
import org.itmodreamteam.medicine.model.TreatmentDefinition;
import org.springframework.stereotype.Component;

@Component
public class DecisionSupportSystem {

    public boolean dssIsCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2) {
        return true;
    }

    public boolean dssIsCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2, Measurement measurement) {
        return true;
    }
}
