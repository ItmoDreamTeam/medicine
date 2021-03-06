package org.itmodreamteam.medicine.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class State {

    private long id;
    private List<TreatmentDefinition> treatments;
}
