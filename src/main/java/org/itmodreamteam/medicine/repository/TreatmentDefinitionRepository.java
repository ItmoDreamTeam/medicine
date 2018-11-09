package org.itmodreamteam.medicine.repository;

import org.itmodreamteam.medicine.model.Patient;
import org.itmodreamteam.medicine.model.TreatmentDefinition;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Repository
public class TreatmentDefinitionRepository {

    public Set<TreatmentDefinition> getCurrentTreatments(Patient patient) {
        return new HashSet<>(Arrays.asList(new TreatmentDefinition(), new TreatmentDefinition()));
    }
}
