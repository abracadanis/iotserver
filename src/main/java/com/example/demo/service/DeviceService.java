package com.example.demo.service;

import com.example.demo.domain.Device;
import com.example.demo.repo.DeviceRepository;
import com.example.demo.service.so.DeviceSo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public ResponseEntity<String> getByKey(String key) {
        // Send request to AdafruitIO
        RestTemplate restTemplate = new RestTemplate();
        String AdafruitIOUrl = "https://io.adafruit.com/api/v2/abrcdns/feeds?x-aio-key=aio_qwVe65OAef4OjOARe4OqJ4FqGTqn";
        ResponseEntity<String> response = restTemplate.getForEntity(AdafruitIOUrl, String.class);

        String espUrl = "http://192.168.0.109:80";
        return response;
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
