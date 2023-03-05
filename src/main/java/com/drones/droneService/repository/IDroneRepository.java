package com.drones.droneService.repository;

import com.drones.droneService.model.DroneEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IDroneRepository extends CrudRepository<DroneEntity, Integer> {

    List<DroneEntity> findAll();
}
