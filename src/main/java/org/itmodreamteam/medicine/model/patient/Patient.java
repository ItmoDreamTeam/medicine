package org.itmodreamteam.medicine.model.patient;

import lombok.*;
import org.itmodreamteam.medicine.model.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Patient extends BaseEntity {

    private String name;
}
