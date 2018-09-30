package org.itmodreamteam.medicine.simulation;

import lombok.Getter;
import lombok.Setter;
import org.itmodreamteam.medicine.model.disease.Disease;
import org.itmodreamteam.medicine.model.patient.CaseHistory;
import org.itmodreamteam.medicine.model.patient.PatientMeasurement;
import org.itmodreamteam.medicine.model.patient.PatientTreatment;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PatientCaseHistory {

    private final CaseHistory caseHistory;
    private Disease disease;
    private final List<PatientMeasurement> measurements;
    private final List<PatientTreatment> treatments;

    public PatientCaseHistory(CaseHistory caseHistory) {
        this.caseHistory = caseHistory;
        this.measurements = new ArrayList<>();
        this.treatments = new ArrayList<>();
    }

    public boolean isDiagnosisMade() {
        return disease != null;
    }
}
