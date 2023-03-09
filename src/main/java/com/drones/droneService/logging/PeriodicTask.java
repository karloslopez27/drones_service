package com.drones.droneService.logging;

import com.drones.droneService.domain.checkbattery.BatteryInfo;
import com.drones.droneService.service.impl.DroneServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PeriodicTask {
    @Autowired
    DroneServiceImpl droneService;


    @Scheduled(fixedRate = 10000, initialDelay = 10000)
    public void registerLogDronesBattery() {
        List<BatteryInfo> batteryInfoList = droneService.checkDronesBattery();
        log.info("Cheking drone's battery levels " + batteryInfoList);
    }
}
