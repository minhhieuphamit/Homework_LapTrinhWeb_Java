package com.example.asm2_restapi.controller;

import com.example.asm2_restapi.model.VehicleInfomation;
import com.example.asm2_restapi.service.VehicleInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/VehicleInfomation/Search")
public class SearchController {
    @Autowired
    private VehicleInfomationService vehicleInfomationService;

    @GetMapping("/BienSoXe")
    public List<VehicleInfomation> SearchBienSoXe(@RequestBody String bienSoXe) {
        return vehicleInfomationService.SeachBienSoXe(bienSoXe);
    }

    @GetMapping("/SoChoNgoi")
    public List<VehicleInfomation> SearchSoChoNgoi(@RequestBody int soChoNgoi) {
        return vehicleInfomationService.SeachSoChoNgoi(soChoNgoi);
    }

    @GetMapping("/NamSX")
    public List<VehicleInfomation> SearchNamSX(@RequestBody String namSX) {
        return vehicleInfomationService.SeachTheoNamSX(namSX);
    }
}
