package org.itmodreamteam.medicine.model;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Measurement {

    private Map<String, Object> items = new HashMap<>();
}
