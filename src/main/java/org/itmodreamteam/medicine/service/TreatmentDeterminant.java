package org.itmodreamteam.medicine.service;

import org.itmodreamteam.medicine.model.CaseHistory;
import org.itmodreamteam.medicine.model.TreatmentDefinition;

import java.util.List;

public interface TreatmentDeterminant {

    List<TreatmentDefinition> determineTreatments(CaseHistory caseHistory);
}
