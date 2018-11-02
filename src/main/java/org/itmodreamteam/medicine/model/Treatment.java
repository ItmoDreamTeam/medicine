package org.itmodreamteam.medicine.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Treatment {

    private List<String> items = new ArrayList<>();
}
