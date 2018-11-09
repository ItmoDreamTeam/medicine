package org.itmodreamteam.medicine.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Measurement {

    private MeasurementDefinition definition;
    private LocalDateTime dateTime;
    private boolean booleanValue;
    private int intValue;
    private double doubleValue;
}
