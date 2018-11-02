package org.itmodreamteam.medicine.model;

import lombok.*;

import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class State {

    private Measurement measurement = new Measurement();
    private Duration checkInterval = Duration.ofSeconds(1);
}
