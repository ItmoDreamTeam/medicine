package org.itmodreamteam.medicine.simulation;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.simulation.step.*;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HealLoopRunner {

    private final AdmissionStepRunner admissionStepRunner;
    private final MeasurementStepRunner measurementStepRunner;
    private final DiagnoseStepRunner diagnoseStepRunner;
    private final TreatmentStepRunner treatmentStepRunner;
    private final DischargeStepRunner dischargeStepRunner;

    public void heal(PatientCaseHistory history) {
        do {
            switch (history.getStep()) {
                case ADMISSION:
                    admissionStepRunner.run(history);
                    break;

                case MEASUREMENT:
                    measurementStepRunner.run(history);
                    break;

                case DIAGNOSE:
                    diagnoseStepRunner.run(history);
                    break;

                case TREATMENT:
                    treatmentStepRunner.run(history);
                    break;

                case DISCHARGE:
                    dischargeStepRunner.run(history);
                    break;
            }
        } while (!history.isDischarged());
    }
}
