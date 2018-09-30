package org.itmodreamteam.medicine.model.patient;

import lombok.*;
import org.itmodreamteam.medicine.model.BaseEntity;
import org.itmodreamteam.medicine.model.disease.Treatment;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class PatientTreatment extends BaseEntity {

    @ManyToOne(optional = false)
    private CaseHistory caseHistory;

    @ManyToOne(optional = false)
    private Treatment treatment;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
