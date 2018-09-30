package org.itmodreamteam.medicine.simulation;

import lombok.Getter;
import lombok.Setter;
import org.itmodreamteam.medicine.model.disease.Disease;
import org.itmodreamteam.medicine.model.patient.CaseHistory;
import org.itmodreamteam.medicine.model.patient.Patient;
import org.itmodreamteam.medicine.model.patient.PatientMeasurement;
import org.itmodreamteam.medicine.model.patient.PatientTreatment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PatientCaseHistory {

    private final CaseHistory caseHistory;
    private Step step;
    private Disease disease;
    private final List<PatientMeasurement> measurements;
    private final List<PatientTreatment> treatments;

    public PatientCaseHistory(CaseHistory caseHistory) {
        this.caseHistory = caseHistory;
        this.step = Step.ADMISSION;
        this.measurements = new ArrayList<>();
        this.treatments = new ArrayList<>();
    }

    public Patient getPatient() {
        return getCaseHistory().getPatient();
    }

    public LocalDateTime getAdmissionDateTime() {
        return getCaseHistory().getAdmissionDateTime();
    }

    public LocalDateTime getDischargeDateTime() {
        return getCaseHistory().getDischargeDateTime();
    }

    public void setDischargeDateTime(LocalDateTime dischargeDateTime) {
        getCaseHistory().setDischargeDateTime(dischargeDateTime);
    }

    public void setAdmissionDateTime(LocalDateTime admissionDateTime) {
        getCaseHistory().setAdmissionDateTime(admissionDateTime);
    }

    public boolean isDiagnosisMade() {
        return disease != null;
    }

    public boolean isDischarged() {
        return getDischargeDateTime() != null;
    }

    public void addPatientMeasurement(PatientMeasurement measurement) {
        this.measurements.add(measurement);
    }

    public void addPatientTreatment(PatientTreatment treatment) {
        this.treatments.add(treatment);
    }
}
