package com.example.demo.service;

import com.example.demo.domain.Device;
import com.example.demo.repo.DeviceRepository;
import com.example.demo.service.so.DeviceSo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeviceService {

    private DeviceRepository deviceRepository;

    @Autowired
    public void setDeviceRepository(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Device create(DeviceSo deviceSo) {
        Device device = new Device();
        device.setKey(deviceSo.getKey());
        device.setValue(false);
        return deviceRepository.save(device);
    }

    public Device getByKey(String key) {
        return deviceRepository.findByKey(key)
                .orElseThrow();
    }

    public Device updateByKey(String key) {
        Device device = deviceRepository.findByKey(key)
                .orElseThrow();
        device.setValue(!device.getValue());
        deviceRepository.save(device);
        return device;
    }

    public void delete(Long id) {
        deviceRepository.deleteById(id);
    }
}
