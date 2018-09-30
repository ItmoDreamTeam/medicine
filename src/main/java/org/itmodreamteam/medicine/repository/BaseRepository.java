package org.itmodreamteam.medicine.repository;

import org.itmodreamteam.medicine.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
