package com.drones.droneService.domain.drone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class Drone {
    //(100 characters max);
    @Max(value = 100, message = "[serialNumber] {drone.validations.size} {this.value}")
    private String serialNumber;

    //(Lightweight, Middleweight, Cruiserweight, Heavyweight);
    private String model;

    //(500gr max);
    @Max(value = 50, message = "[weightLimit] {drone.validations.size} {this.value}")
    private int weightLimit;

    //(percentage)
    @Size(min = 0, max = 100, message = "[weightLimit] {drone.validations.size} {this.value}")
    private int batteryCapacity;

    //(IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING).
    private String state;
}
