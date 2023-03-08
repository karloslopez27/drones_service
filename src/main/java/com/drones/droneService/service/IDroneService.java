package com.drones.droneService.service;

import com.drones.droneService.domain.drone.Drone;
import com.drones.droneService.domain.load.LoadDrone;
import com.drones.droneService.exception.DispatchDroneException;
import org.springframework.stereotype.Service;

@Service
public interface IDroneService {

    Drone registerDrone(Drone drone);

    Drone loadDrone(LoadDrone loadDrone) throws DispatchDroneException;

}
