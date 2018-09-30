package org.itmodreamteam.medicine.simulation.step;

import lombok.extern.slf4j.Slf4j;
import org.itmodreamteam.medicine.simulation.PatientCaseHistory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class DischargeStepRunner implements StepRunner {

    @Override
    public void run(PatientCaseHistory history) {
        history.setDischargeDateTime(LocalDateTime.now());
        log.info("{} -> discharge", history.getPatient().getName());
    }
}
