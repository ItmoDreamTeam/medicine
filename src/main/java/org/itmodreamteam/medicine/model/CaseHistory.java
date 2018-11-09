package org.itmodreamteam.medicine.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CaseHistory {

    private Patient patient;
    private MedicalProcess medicalProcess;
    private State currentState;
    private LocalDateTime admissionTime;
    private LocalDateTime dischargeTime;
}
