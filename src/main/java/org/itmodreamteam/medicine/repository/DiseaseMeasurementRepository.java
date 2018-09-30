package org.itmodreamteam.medicine.repository;

import org.itmodreamteam.medicine.model.disease.Disease;
import org.itmodreamteam.medicine.model.disease.DiseaseMeasurement;

import java.util.List;

public interface DiseaseMeasurementRepository extends BaseRepository<DiseaseMeasurement> {

    List<DiseaseMeasurement> findAllByDisease(Disease disease);
}
