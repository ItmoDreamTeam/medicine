package org.itmodreamteam.medicine.simulation.step;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.simulation.PatientCaseHistory;
import org.itmodreamteam.medicine.simulation.Step;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TreatmentStepRunner implements StepRunner {

    @Override
    public void run(PatientCaseHistory history) {
        history.setStep(Step.DISCHARGE);
    }
}
