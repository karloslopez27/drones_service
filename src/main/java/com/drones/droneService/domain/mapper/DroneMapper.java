package com.drones.droneService.domain.mapper;

import com.drones.droneService.domain.drone.Drone;
import com.drones.droneService.model.DroneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DroneMapper {
    DroneMapper INSTANCE = Mappers.getMapper(DroneMapper.class);

    DroneEntity convertDrone(Drone drone);

    Drone convertDroneEntity(DroneEntity droneEntity);
}
