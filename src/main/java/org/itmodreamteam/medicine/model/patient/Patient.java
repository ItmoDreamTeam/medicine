package org.itmodreamteam.medicine.model.patient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.itmodreamteam.medicine.model.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Patient extends BaseEntity {

    private String name;
}
