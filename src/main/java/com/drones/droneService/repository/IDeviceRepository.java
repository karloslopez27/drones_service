package com.drones.droneService.repository;

import com.drones.droneService.model.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeviceRepository extends JpaRepository<DeviceEntity, Integer> {

}
