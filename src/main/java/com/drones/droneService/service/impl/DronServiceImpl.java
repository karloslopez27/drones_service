package com.drones.droneService.service.impl;

import com.drones.droneService.domain.device.Device;
import com.drones.droneService.domain.drone.Drone;
import com.drones.droneService.domain.load.LoadDrone;
import com.drones.droneService.domain.mapper.DroneMapper;
import com.drones.droneService.domain.utils.DroneUtils;
import com.drones.droneService.exception.DispatchDroneException;
import com.drones.droneService.model.DeviceEntity;
import com.drones.droneService.model.DroneEntity;
import com.drones.droneService.repository.IDeviceRepository;
import com.drones.droneService.repository.IDroneRepository;
import com.drones.droneService.service.IDroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DronServiceImpl implements IDroneService {

    @Autowired
    IDroneRepository droneRepository;

    @Autowired
    IDeviceRepository deviceRepository;

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
        Optional<DeviceEntity> deviceOptional = deviceRepository.findById(loadDrone.getDeviceId());
        if (droneOptional.isPresent()) {
            DroneEntity droneEntity = droneOptional.get();
            if (deviceOptional.isPresent()) {
                DeviceEntity medicationEntity = deviceOptional.get();
                if (DroneUtils.isValidLoadConditions(droneEntity, medicationEntity)) {
                    droneEntity.getLoadedDevices().add(medicationEntity);
                    DroneEntity savedDrone = droneRepository.save(droneEntity);
                    Drone drone = DroneMapper.INSTANCE.convertDroneEntity(savedDrone);
                    return drone;
                } else {
                    throw new DispatchDroneException("Cannot load this device. Drone capacity exceeded or invalid drone state.");
                }
            } else {
                throw new DispatchDroneException("Cannot load this device. Device not found.");
            }
        } else {
            throw new DispatchDroneException("Cannot load the drone. Drone not found.");
        }
    }

    @Override
    public List<Device> checkLoadedItems(Integer droneId) throws DispatchDroneException {
        Optional<DroneEntity> droneOptional = droneRepository.findById(droneId);
        if (droneOptional.isPresent()) {
            DroneEntity droneEntity = droneOptional.get();
            Drone drone = DroneMapper.INSTANCE.convertDroneEntity(droneEntity);
            return drone.getLoadedDevices();
        } else {
            throw new DispatchDroneException("Drone not found.");
        }
    }

    @Override
    public List<Integer> checkAvailableDronesForLoading() throws DispatchDroneException {
        List<Integer> availableDrones = droneRepository.findDronesForLoading();
        return availableDrones;
    }

    @Override
    public Integer checkABattery(Integer droneId) throws DispatchDroneException {
        Optional<DroneEntity> droneOptional = droneRepository.findById(droneId);
        if (droneOptional.isPresent()) {
            DroneEntity droneEntity = droneOptional.get();
            Drone drone = DroneMapper.INSTANCE.convertDroneEntity(droneEntity);
            return drone.getBatteryCapacity();
        } else {
            throw new DispatchDroneException("Drone not found.");
        }
    }
}
