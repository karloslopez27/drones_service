package com.drones.droneService.repository;

import com.drones.droneService.model.MedicationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMedicationRespository extends CrudRepository<MedicationEntity, Integer> {

    List<MedicationEntity> findAll();
}
