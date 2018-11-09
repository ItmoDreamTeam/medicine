package org.itmodreamteam.medicine.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Treatment {

    private TreatmentDefinition definition;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
