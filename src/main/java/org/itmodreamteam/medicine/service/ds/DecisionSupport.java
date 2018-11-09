package org.itmodreamteam.medicine.service.ds;

import org.itmodreamteam.medicine.model.MeasurementDefinition;
import org.itmodreamteam.medicine.model.TreatmentDefinition;

public interface DecisionSupport {

    boolean isCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2);

    boolean isCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2, MeasurementDefinition measurement);
}
