package org.itmodreamteam.medicine.simulation.step;

import lombok.extern.slf4j.Slf4j;
import org.itmodreamteam.medicine.simulation.PatientCaseHistory;
import org.itmodreamteam.medicine.simulation.Step;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class AdmissionStepRunner implements StepRunner {

    @Override
    public void run(PatientCaseHistory history) {
        history.setAdmissionDateTime(LocalDateTime.now());
        history.setStep(Step.MEASUREMENT);
        log.info("{} -> admission", history.getPatient().getName());
    }
}
