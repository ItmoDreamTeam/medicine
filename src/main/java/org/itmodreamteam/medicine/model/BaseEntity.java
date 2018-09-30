package org.itmodreamteam.medicine.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@EqualsAndHashCode(of = "id")
@ToString
public class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
}
