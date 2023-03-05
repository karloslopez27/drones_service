package com.drones.droneService.service.impl;

import com.drones.droneService.domain.drone.Drone;
import com.drones.droneService.domain.mapper.DroneMapper;
import com.drones.droneService.model.DroneEntity;
import com.drones.droneService.repository.IDroneRepository;
import com.drones.droneService.service.IDroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DronServiceImpl implements IDroneService {

    @Autowired
    IDroneRepository droneRepository;

    @Override
    public Drone registerDrone(Drone drone) {
        Optional<DroneEntity> droneOptional = droneRepository.findById(drone.getId());

        DroneEntity droneEntity = DroneMapper.INSTANCE.convertDrone(drone);

        if (!droneOptional.isPresent()) {
            DroneEntity savedDroneEntity = droneRepository.save(droneEntity);
            return DroneMapper.INSTANCE.convertDroneEntity(savedDroneEntity);
        } else {
            return new Drone();
        }

    }
}
