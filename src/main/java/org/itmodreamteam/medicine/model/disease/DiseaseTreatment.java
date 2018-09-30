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
public class DiseaseTreatment extends BaseEntity {

    @ManyToOne(optional = false)
    private Disease disease;

    @ManyToOne(optional = false)
    private Treatment treatment;

    private int sequentialNumber;
}
