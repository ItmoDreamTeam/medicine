package org.itmodreamteam.medicine.model.disease;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.itmodreamteam.medicine.model.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Treatment extends BaseEntity {

    private String name;
}
