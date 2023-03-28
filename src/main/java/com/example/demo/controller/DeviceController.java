package com.example.demo.controller;

import com.example.demo.domain.Device;
import com.example.demo.service.DeviceService;
import com.example.demo.service.so.DeviceSo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class DeviceController {
    private DeviceService deviceService;

    @Autowired
    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/home")
    public String getHome() {
        return "Home";
    }

    @PostMapping("/")
    public Device create(@RequestBody DeviceSo deviceSo) {
        return deviceService.create(deviceSo);
    }

    @GetMapping("/{key}")
    public Device getByKey(@PathVariable("key") String key) {
        return deviceService.getByKey(key);
    }

    @PutMapping("/{key}")
    public Device updateByKey(@PathVariable("key") String key) {
        return deviceService.updateByKey(key);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        deviceService.delete(id);
    }
}
