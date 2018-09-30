package org.itmodreamteam.medicine.model.disease;

import lombok.*;
import org.itmodreamteam.medicine.model.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Treatment extends BaseEntity {

    private String name;
}
