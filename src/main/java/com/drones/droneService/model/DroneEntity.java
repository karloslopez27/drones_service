package com.drones.droneService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drone")
public class DroneEntity {

    @Id
    private Integer id;

    private String serialNumber;

    private String model;

    private Integer weightLimit;

    private Integer batteryCapacity;

    private String state;
}
