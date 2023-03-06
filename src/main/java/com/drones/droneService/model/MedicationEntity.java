package com.drones.droneService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medication")
public class MedicationEntity {

    @Id
    private String id;

    private String name;

    private Integer weight;

    private String code;

    private String image;

}
