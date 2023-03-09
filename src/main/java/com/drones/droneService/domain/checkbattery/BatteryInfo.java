package com.drones.droneService.domain.checkbattery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BatteryInfo {
    private Integer droneId;
    private Integer droneBattery;
}
