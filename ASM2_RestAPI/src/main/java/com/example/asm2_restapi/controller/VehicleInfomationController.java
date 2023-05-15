package com.example.asm2_restapi.controller;

import com.example.asm2_restapi.model.VehicleInfomation;
import com.example.asm2_restapi.service.VehicleInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/VehicleInfomation")
public class VehicleInfomationController {
    @Autowired
    private VehicleInfomationService vehicleInfomationService;

    @GetMapping
    public List<VehicleInfomation> getAllVehicleInfomation() {
        return vehicleInfomationService.getAllVehicleInfomation();
    }

    @PostMapping
    public VehicleInfomation addVehicleInfomation(@RequestBody VehicleInfomation NewVehicleInfomation) {
        vehicleInfomationService.addVehicleInfomation(NewVehicleInfomation);
        return NewVehicleInfomation;
    }

    @PutMapping("/update/{bienSoXe}")
    public VehicleInfomation updateVehicleInfomation(@PathVariable String bienSoXe, @RequestBody VehicleInfomation NewVehicleInfomation) {
        vehicleInfomationService.updateVehicleInfomation(bienSoXe, NewVehicleInfomation);
        return NewVehicleInfomation;
    }

    @DeleteMapping
    public void DeleteBienSoXe(@RequestBody String bienSoXe) {
        vehicleInfomationService.removeVehicleInfomation(bienSoXe);
    }
}
