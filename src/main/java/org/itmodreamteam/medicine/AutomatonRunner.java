package org.itmodreamteam.medicine;

import lombok.RequiredArgsConstructor;
import org.itmodreamteam.medicine.model.CaseHistory;
import org.itmodreamteam.medicine.model.State;
import org.itmodreamteam.medicine.model.TreatmentDefinition;
import org.itmodreamteam.medicine.service.MedicalProcessFactory;
import org.itmodreamteam.medicine.service.MedicalProcessFactoryProvider;
import org.itmodreamteam.medicine.service.NextStateDeterminant;
import org.itmodreamteam.medicine.service.TreatmentDeterminant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AutomatonRunner {

    private final MedicalProcessFactoryProvider medicalProcessFactoryProvider;

    public void run(CaseHistory caseHistory) {
        do {
            processState(caseHistory);
        } while (!caseHistory.getMedicalProcess().getFinalState().equals(caseHistory.getCurrentState()));
    }

    private void processState(CaseHistory caseHistory) {
        State state = caseHistory.getCurrentState();
        MedicalProcessFactory medicalProcessFactory = medicalProcessFactoryProvider.provide(caseHistory.getMedicalProcess(), state);
        TreatmentDeterminant treatmentDeterminant = medicalProcessFactory.getTreatmentDeterminant();
        List<TreatmentDefinition> treatments = treatmentDeterminant.determineTreatments(caseHistory);
        treatments.forEach(treatment -> applyTreatment(caseHistory, treatment));
        wait(state);
        takeMeasurements(caseHistory);
        NextStateDeterminant nextStateDeterminant = medicalProcessFactory.getNextStateDeterminant();
        State nextState = nextStateDeterminant.determineNextState(caseHistory);
        caseHistory.setCurrentState(nextState);
    }

    private void applyTreatment(CaseHistory caseHistory, TreatmentDefinition treatment) {
    }

    private void wait(State state) {
    }

    private void takeMeasurements(CaseHistory caseHistory) {
    }
}
