package com.drones.droneService.controller;

import com.drones.droneService.domain.drone.Drone;
import com.drones.droneService.service.IDroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
