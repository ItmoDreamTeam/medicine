package org.itmodreamteam.medicine.service.ds;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DecisionSupportAggregator {

    private final Set<DecisionSupport> decisionSupports;
}
