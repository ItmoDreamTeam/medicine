package org.itmodreamteam.medicine.simulation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HealLoopRunner {

    private final MeasurementStage measurementStage;
    private final DiagnoseStage diagnoseStage;
    private final TreatmentStage treatmentStage;

    public void heal(PatientCaseHistory history) {
        Stage stage = Stage.ADMISSION;
        while (stage != Stage.DISCHARGE) {
            switch (stage) {
                case ADMISSION:
                    stage = Stage.MEASUREMENT;
                    break;

                case MEASUREMENT:
                    measurementStage.takeMeasurements(history);
                    stage = Stage.DIAGNOSE;
                    break;

                case DIAGNOSE:
                    diagnoseStage.diagnose(history);
                    stage = history.isDiagnosisMade() ? Stage.TREATMENT : Stage.MEASUREMENT;
                    break;

                case TREATMENT:
                    treatmentStage.treat(history);
                    stage = Stage.DISCHARGE;
                    break;
            }
        }
    }
}
