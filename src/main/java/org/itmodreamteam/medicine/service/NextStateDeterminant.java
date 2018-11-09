package org.itmodreamteam.medicine.service;

import org.itmodreamteam.medicine.model.CaseHistory;
import org.itmodreamteam.medicine.model.State;

public interface NextStateDeterminant {

    State determineNextState(CaseHistory caseHistory);
}
