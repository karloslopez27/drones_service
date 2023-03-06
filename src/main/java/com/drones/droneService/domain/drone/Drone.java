package com.drones.droneService.domain.drone;

import com.drones.droneService.domain.enumerator.ModelEnum;
import com.drones.droneService.domain.enumerator.StateEnum;
import com.drones.droneService.domain.enumerator.ValueOfEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Drone {

    @Valid
    @NotNull(message = "[id] {drone.validations.nullBlank}")
    private Integer id;

    @Valid
    @NotBlank(message = "[serialNumber] {drone.validations.nullBlank}")
    @NotNull(message = "[serialNumber] {drone.validations.nullBlank}")
    @Size(min = 1, max = 100, message = "[serialNumber] {drone.validations.size} (1-100)")
    private String serialNumber;

    @Valid
    @NotBlank(message = "[model] {drone.validations.nullBlank}")
    @NotNull(message = "[model] {drone.validations.nullBlank}")
    @ValueOfEnum(enumClass = ModelEnum.class, message = "{drone.validations.enum}")
    private String model;

    @Valid
    @NotNull(message = "[weightLimit] {drone.validations.nullBlank}")
    @Min(value = 1, message = "[weightLimit] {drone.validations.size} (1)")
    @Max(value = 500, message = "[weightLimit] {drone.validations.size} (500)")
    private Integer weightLimit;

    @Valid
    @NotNull(message = "[batteryCapacity] {drone.validations.nullBlank}")
    @Min(value = 0, message = "[weightLimit] {drone.validations.size} (0)")
    @Max(value = 100, message = "[weightLimit] {drone.validations.size} (100)")
    private Integer batteryCapacity;

    @Valid
    @NotBlank(message = "[state] {drone.validations.nullBlank}")
    @NotNull(message = "[state] {drone.validations.nullBlank}")
    @ValueOfEnum(enumClass = StateEnum.class, message = "{drone.validations.enum}")
    private String state;
}
