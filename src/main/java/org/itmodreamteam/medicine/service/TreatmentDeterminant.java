package org.itmodreamteam.medicine.service;

import org.itmodreamteam.medicine.model.CaseHistory;

import java.util.List;

public interface TreatmentDeterminant {

    List<TreatmentDeterminant> determineTreatments(CaseHistory caseHistory);
}
