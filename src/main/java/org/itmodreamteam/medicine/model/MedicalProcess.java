package org.itmodreamteam.medicine.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MedicalProcess {

    private long id;
    private State initialState;
    private State finalState;
}
