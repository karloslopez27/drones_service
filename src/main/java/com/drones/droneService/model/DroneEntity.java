package com.drones.droneService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    private Integer weightLoad;

    private Integer batteryCapacity;

    private String state;

    @ManyToMany
    @JoinTable(
            name = "drone_device",
            joinColumns = @JoinColumn(name = "drone_id"),
            inverseJoinColumns = @JoinColumn(name = "device_id"))
    private List<DeviceEntity> loadedDevices;
}
