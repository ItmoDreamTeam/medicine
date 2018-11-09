package org.itmodreamteam.medicine.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {

    private List<Treatment> treatments;
    private List<Measurement> measurements;
}
