package com.drones.droneService.service;

import com.drones.droneService.domain.drone.Drone;
import org.springframework.stereotype.Service;

@Service
public interface IDroneService {

    Drone registerDrone(Drone drone);

}
