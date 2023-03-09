package com.drones.droneService.repository;

import com.drones.droneService.model.DroneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IDroneRepository extends JpaRepository<DroneEntity, Integer> {

    @Query(value = "SELECT d.ID FROM Drone d WHERE (d.STATE = 'IDLE' OR d.STATE = 'LOADING') AND d.WEIGHT_LOAD < WEIGHT_LIMIT", nativeQuery = true)
    List<Integer> findDronesForLoading();
}
