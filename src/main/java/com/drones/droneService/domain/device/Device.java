package com.drones.droneService.domain.device;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Device {

    private Integer id;

    @Pattern(regexp = "^[a-zA-Z0-9_-]+$")
    private String name;

    private Integer weight;

    @Pattern(regexp = "^[A-Z0-9_]+$")
    private String code;

    //image URL maybe stored in some cloud blob storage
    private String image;

}
