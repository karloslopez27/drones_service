package com.drones.droneService.service.impl;

import com.drones.droneService.domain.drone.Drone;
import com.drones.droneService.domain.load.LoadDrone;
import com.drones.droneService.domain.mapper.DroneMapper;
import com.drones.droneService.domain.utils.DroneUtils;
import com.drones.droneService.exception.DispatchDroneException;
import com.drones.droneService.model.DeviceEntity;
import com.drones.droneService.model.DroneEntity;
import com.drones.droneService.repository.IDeviceRespository;
import com.drones.droneService.repository.IDroneRepository;
import com.drones.droneService.service.IDroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DronServiceImpl implements IDroneService {

    @Autowired
    IDroneRepository droneRepository;

    @Autowired
    IDeviceRespository deviceRespository;

    @Override
    public Drone registerDrone(Drone drone) {
        Optional<DroneEntity> droneOptional = droneRepository.findById(drone.getId());

        DroneEntity droneEntity = DroneMapper.INSTANCE.convertDrone(drone);

        if (!droneOptional.isPresent()) {
            DroneEntity savedDroneEntity = droneRepository.save(droneEntity);
            return DroneMapper.INSTANCE.convertDroneEntity(savedDroneEntity);
        } else {
            return new Drone();
        }

    }

    @Override
    public Drone loadDrone(LoadDrone loadDrone) throws DispatchDroneException {
        Optional<DroneEntity> droneOptional = droneRepository.findById(loadDrone.getDroneId());
        Optional<DeviceEntity> deviceOptional = deviceRespository.findById(loadDrone.getDeviceId());
        if (droneOptional.isPresent()) {
            DroneEntity droneEntity = droneOptional.get();
            if (deviceOptional.isPresent()) {
                DeviceEntity medicationEntity = deviceOptional.get();
                if (DroneUtils.validateLoadCapacity(droneEntity, medicationEntity)) {
                    droneEntity.getLoadedDevices().add(medicationEntity);
                    DroneEntity savedDrone = droneRepository.save(droneEntity);
                    Drone drone = DroneMapper.INSTANCE.convertDroneEntity(savedDrone);
                    return drone;
                } else {
                    throw new DispatchDroneException("Cannot load this device. Drone capacity exceeded.");
                }
            } else {
                throw new DispatchDroneException("Cannot load this device. Device not found.");
            }
        } else {
            throw new DispatchDroneException("Cannot load the drone. Drone not found.");
        }
    }
}
