package org.itmodreamteam.medicine.simulation.step;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.itmodreamteam.medicine.model.disease.DiseaseTreatment;
import org.itmodreamteam.medicine.model.disease.Treatment;
import org.itmodreamteam.medicine.model.patient.PatientTreatment;
import org.itmodreamteam.medicine.repository.DiseaseTreatmentRepository;
import org.itmodreamteam.medicine.repository.PatientTreatmentRepository;
import org.itmodreamteam.medicine.simulation.PatientCaseHistory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class TreatmentStepRunner implements StepRunner {

    private final DiseaseTreatmentRepository diseaseTreatmentRepository;
    private final PatientTreatmentRepository patientTreatmentRepository;

    @Override
    public void run(PatientCaseHistory history) {
        assignTreatments(history);
    }

    private void assignTreatments(PatientCaseHistory history) {
        Random random = ThreadLocalRandom.current();
        List<Treatment> treatments = getNotAssignedTreatments(history, random.nextInt(5) + 1);
        treatments.forEach(treatment -> assignTreatment(history, treatment));
        log.info("{} -> {} treatments assigned", history.getPatient().getName(), treatments.size());
    }

    private List<Treatment> getNotAssignedTreatments(PatientCaseHistory history, int limit) {
        List<Treatment> assignedTreatments = history.getTreatments().parallelStream()
                .map(PatientTreatment::getTreatment)
                .collect(Collectors.toList());
        List<Treatment> notAssignedTreatments = diseaseTreatmentRepository.findAllByDiseaseOrderBySequentialNumber(history.getDisease())
                .stream()
                .filter(diseaseTreatment -> !assignedTreatments.contains(diseaseTreatment.getTreatment()))
                .map(DiseaseTreatment::getTreatment)
                .collect(Collectors.toList());
        return notAssignedTreatments.stream().limit(limit).collect(Collectors.toList());
    }

    private void assignTreatment(PatientCaseHistory history, Treatment treatment) {
        PatientTreatment patientTreatment = new PatientTreatment(history.getCaseHistory(), treatment, LocalDateTime.now(), LocalDateTime.now().plusDays(3));
        patientTreatment = patientTreatmentRepository.save(patientTreatment);
        history.addPatientTreatment(patientTreatment);
    }
}
