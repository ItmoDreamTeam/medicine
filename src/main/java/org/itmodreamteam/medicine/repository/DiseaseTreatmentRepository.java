package org.itmodreamteam.medicine.repository;

import org.itmodreamteam.medicine.model.disease.Disease;
import org.itmodreamteam.medicine.model.disease.DiseaseTreatment;

import java.util.List;

public interface DiseaseTreatmentRepository extends BaseRepository<DiseaseTreatment> {

    List<DiseaseTreatment> findAllByDiseaseOrderBySequentialNumber(Disease disease);
}
