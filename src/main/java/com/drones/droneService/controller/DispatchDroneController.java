package com.drones.droneService.controller;

import com.drones.droneService.domain.device.Device;
import com.drones.droneService.domain.drone.Drone;
import com.drones.droneService.domain.load.LoadDrone;
import com.drones.droneService.exception.DispatchDroneException;
import com.drones.droneService.service.IDroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dispatch-drones")
public class DispatchDroneController {

    @Autowired
    private IDroneService droneService;

    @PostMapping("/drone")
    public ResponseEntity<Drone> registerDrone(@Valid @RequestBody Drone drone) {
        Drone savedDrone = droneService.registerDrone(drone);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDrone);
    }

    @PostMapping("/drone/load-items")
    public ResponseEntity<Drone> loadDrone(@Valid @RequestBody LoadDrone loadDrone) throws DispatchDroneException {
        Drone savedDrone = droneService.loadDrone(loadDrone);
        return ResponseEntity.status(HttpStatus.OK).body(savedDrone);

    }

    @GetMapping("/drone/{drone-id}/check-items")
    public ResponseEntity<List<Device>> checkDroneItems(@PathVariable("drone-id") Integer droneId) throws DispatchDroneException {
        List<Device> devices = droneService.checkLoadedItems(droneId);
        return ResponseEntity.status(HttpStatus.OK).body(devices);

    }

    @GetMapping("/drone/check-for-loading")
    public ResponseEntity<List<Integer>> checkAvailableDronesForLoading() throws DispatchDroneException {
        List<Integer> drones = droneService.checkAvailableDronesForLoading();
        return ResponseEntity.status(HttpStatus.OK).body(drones);

    }

    @GetMapping("/drone/{drone-id}/check-battery")
    public ResponseEntity<Integer> checkDroneBattery(@PathVariable("drone-id") Integer droneId) throws DispatchDroneException {
        int battery = droneService.checkABattery(droneId);
        return ResponseEntity.status(HttpStatus.OK).body(battery);

    }
}
