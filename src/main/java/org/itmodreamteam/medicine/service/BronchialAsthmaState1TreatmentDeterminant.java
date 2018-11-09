package org.itmodreamteam.medicine.service;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.model.CaseHistory;
import org.itmodreamteam.medicine.model.TreatmentDefinition;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BronchialAsthmaState1TreatmentDeterminant implements TreatmentDeterminant {

    @Override
    public List<TreatmentDefinition> determineTreatments(CaseHistory caseHistory) {
        return Collections.emptyList();
    }
}
