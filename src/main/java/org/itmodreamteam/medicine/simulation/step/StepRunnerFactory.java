package org.itmodreamteam.medicine.simulation.step;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.simulation.Step;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StepRunnerFactory {

    private final AdmissionStepRunner admissionStepRunner;
    private final MeasurementStepRunner measurementStepRunner;
    private final DiagnoseStepRunner diagnoseStepRunner;
    private final TreatmentStepRunner treatmentStepRunner;
    private final DischargeStepRunner dischargeStepRunner;

    public StepRunner getForStep(Step step) {
        switch (step) {
            case ADMISSION:
                return admissionStepRunner;
            case MEASUREMENT:
                return measurementStepRunner;
            case DIAGNOSE:
                return diagnoseStepRunner;
            case TREATMENT:
                return treatmentStepRunner;
            case DISCHARGE:
                return dischargeStepRunner;
        }
        throw new RuntimeException("No StepRunner provided for step=" + step);
    }
}
