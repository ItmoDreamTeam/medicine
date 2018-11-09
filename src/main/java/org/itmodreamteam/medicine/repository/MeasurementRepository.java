package org.itmodreamteam.medicine.repository;

import org.itmodreamteam.medicine.model.Measurement;
import org.itmodreamteam.medicine.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class MeasurementRepository {

    public Measurement getRelevantMeasurement(Patient patient, long id) {
        Measurement measurement = new Measurement();
        measurement.setDoubleValue(34.87654);
        return measurement;
    }

    public Set<Measurement> getSignificantMeasurements(Patient patient) {
        return new HashSet<>();
    }
}
