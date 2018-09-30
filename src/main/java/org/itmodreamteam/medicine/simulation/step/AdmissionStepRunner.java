package org.itmodreamteam.medicine.simulation.step;

import org.itmodreamteam.medicine.simulation.PatientCaseHistory;
import org.itmodreamteam.medicine.simulation.Step;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AdmissionStepRunner implements StepRunner {

    @Override
    public void run(PatientCaseHistory history) {
        history.setAdmissionDateTime(LocalDateTime.now());
        history.setStep(Step.MEASUREMENT);
    }
}
