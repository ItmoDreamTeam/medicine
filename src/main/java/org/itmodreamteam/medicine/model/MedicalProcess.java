package org.itmodreamteam.medicine.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MedicalProcess {

    private String name = "abc";
    private State initialState = new State();
    private State finalState = new State();
}
