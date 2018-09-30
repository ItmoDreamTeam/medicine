package org.itmodreamteam.medicine.model.disease;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.itmodreamteam.medicine.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class DiseaseMeasurement extends BaseEntity {

    @ManyToOne(optional = false)
    private Disease disease;

    @ManyToOne(optional = false)
    private Measurement measurement;

    private double valueFrom;
    private double valueTo;
}
