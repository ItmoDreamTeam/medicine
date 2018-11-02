package org.itmodreamteam.medicine.model;

import lombok.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class State {

    private Measurement measurement = new Measurement();
    private Duration checkInterval = Duration.ofSeconds(1);
    private List<Treatment> treatments = Arrays.asList(
            new Treatment(), new Treatment(), new Treatment()
    );
}
