package com.drones.droneService.service;

import com.drones.droneService.domain.device.Device;
import com.drones.droneService.domain.drone.Drone;
import com.drones.droneService.domain.load.LoadDrone;
import com.drones.droneService.exception.DispatchDroneException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDroneService {

    Drone registerDrone(Drone drone);

    Drone loadDrone(LoadDrone loadDrone) throws DispatchDroneException;

    List<Device> checkLoadedItems(Integer droneId) throws DispatchDroneException;

    List<Integer> checkAvailableDronesForLoading() throws DispatchDroneException;

    Integer checkABattery(Integer droneId) throws DispatchDroneException;

}
