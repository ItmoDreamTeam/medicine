package org.itmodreamteam.medicine.service.ds;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.model.Measurement;
import org.itmodreamteam.medicine.model.TreatmentDefinition;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DecisionSupportAggregator implements DecisionSupport {

    private final Set<DecisionSupport> decisionSupports;

    @Override
    public boolean isCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2) {
        return false;
    }

    @Override
    public boolean isCompatible(TreatmentDefinition treatment1, TreatmentDefinition treatment2, Measurement measurement) {
        return false;
    }
}
