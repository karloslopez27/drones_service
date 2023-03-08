package com.drones.droneService.repository;

import com.drones.droneService.model.DeviceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IDeviceRespository extends CrudRepository<DeviceEntity, Integer> {

    List<DeviceEntity> findAll();
}
