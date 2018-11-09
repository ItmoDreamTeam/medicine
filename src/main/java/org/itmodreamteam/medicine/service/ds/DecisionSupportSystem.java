package org.itmodreamteam.medicine.service.ds;

import org.itmodreamteam.medicine.model.MeasurementDefinition;
import org.itmodreamteam.medicine.model.TreatmentDefinition;

public class DecisionSupportSystem {

    public boolean dssIsCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2) {
        return true;
    }

    public boolean dssIsCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2, MeasurementDefinition measurement) {
        return true;
    }
}
