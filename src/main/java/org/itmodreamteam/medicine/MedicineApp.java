package org.itmodreamteam.medicine;

import lombok.SneakyThrows;
import org.itmodreamteam.medicine.model.Measurement;
import org.itmodreamteam.medicine.model.MedicalProcess;
import org.itmodreamteam.medicine.model.State;
import org.itmodreamteam.medicine.model.Treatment;
import org.itmodreamteam.medicine.service.Measurer;
import org.itmodreamteam.medicine.service.MedicalProcessDeterminant;
import org.itmodreamteam.medicine.service.StateDeterminant;
import org.itmodreamteam.medicine.service.TreatmentFactory;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class MedicineApp {

    public static void main(String[] args) {
        Measurement initialMeasurement = Measurer.measure();
        MedicalProcess medicalProcess = MedicalProcessDeterminant.determine(initialMeasurement);
        treat(medicalProcess);
    }

    @SneakyThrows
    private static void treat(MedicalProcess medicalProcess) {
        State state = medicalProcess.getInitialState();
        do {
            State currentState = state;
            CompletableFuture.allOf(
                    CompletableFuture.runAsync(() -> treat(currentState)),
                    CompletableFuture.runAsync(() -> wait(currentState))
            ).get();
            Measurement measurement = Measurer.measure();
            state = StateDeterminant.determineNextState(currentState, measurement);
        } while (!state.equals(medicalProcess.getFinalState()));
    }

    private static void treat(State state) {
        Measurement measurement = Measurer.measure();
        Treatment treatment = TreatmentFactory.getTreatment(state, measurement);
        Consumer<Treatment> treatmentConsumer = t -> System.out.println("Treat...");
        treatmentConsumer.accept(treatment);
    }

    @SneakyThrows
    private static void wait(State state) {
        Thread.sleep(state.getCheckInterval().toMillis());
    }
}
