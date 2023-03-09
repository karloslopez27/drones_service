package com.drones.droneService.domain.utils;

import com.drones.droneService.model.DeviceEntity;
import com.drones.droneService.model.DroneEntity;

public class DroneUtils {

    public static boolean isValidLoadConditions(DroneEntity drone, DeviceEntity device) {
        int totalWeight = drone.getWeightLoad() + device.getWeight();
        String state = drone.getState();
        if (totalWeight < drone.getWeightLimit() && (state.equals("IDLE") ||
                state.equals("LOADING")) && drone.getBatteryCapacity() >= 25) {
            drone.setWeightLoad(totalWeight);
            drone.setState("LOADING");
            return true;
        } else if (totalWeight == drone.getWeightLimit() && (state.equals("IDLE") ||
                state.equals("LOADING")) && drone.getBatteryCapacity() >= 25) {
            drone.setWeightLoad(totalWeight);
            drone.setState("LOADED");
            return true;
        } else {
            return false;
        }
    }
}
