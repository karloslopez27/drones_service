package com.drones.droneService.domain.utils;

import com.drones.droneService.model.DroneEntity;
import com.drones.droneService.model.DeviceEntity;

public class DroneUtils {

    public static boolean validateLoadCapacity(DroneEntity drone, DeviceEntity device) {
        int totalWeight = drone.getWeightLoad() + device.getWeight();
        if (totalWeight <= drone.getWeightLimit()) {
            drone.setWeightLoad(totalWeight);
            return true;
        }
        else{
            return false;
        }
    }
}
