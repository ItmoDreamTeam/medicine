package org.itmodreamteam.medicine.simulation.step;

import org.itmodreamteam.medicine.simulation.PatientCaseHistory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DischargeStepRunner implements StepRunner {

    @Override
    public void run(PatientCaseHistory history) {
        history.setDischargeDateTime(LocalDateTime.now());
    }
}
