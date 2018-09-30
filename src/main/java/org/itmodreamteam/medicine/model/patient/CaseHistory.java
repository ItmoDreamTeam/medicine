package org.itmodreamteam.medicine.model.patient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.itmodreamteam.medicine.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class CaseHistory extends BaseEntity {

    @ManyToOne(optional = false)
    private Patient patient;

    private LocalDateTime admissionDateTime;
    private LocalDateTime dischargeDateTime;

    public CaseHistory(Patient patient, LocalDateTime admissionDateTime) {
        this.patient = patient;
        this.admissionDateTime = admissionDateTime;
    }
}
