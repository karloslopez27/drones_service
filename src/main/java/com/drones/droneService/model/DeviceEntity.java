package com.drones.droneService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medication")
public class DeviceEntity {

    @Id
    private Integer id;

    private String name;

    private Integer weight;

    private String code;

    private String image;

    @ManyToMany(mappedBy = "loadedDevices")
    private List<DroneEntity> carryDrones;

}
