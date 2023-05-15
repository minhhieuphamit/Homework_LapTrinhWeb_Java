package com.example.asm2_restapi.service;

import com.example.asm2_restapi.model.VehicleInfomation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VehicleInfomationService {
    private List<VehicleInfomation> vehicleInfomationList = new ArrayList<>(Arrays.asList(
            new VehicleInfomation("29A-12334", LocalDate.of(2021, 1, 1), 4, true),
            new VehicleInfomation("29A-12335", LocalDate.of(2023, 1, 1), 4, true)
    ));

    public List<VehicleInfomation> getAllVehicleInfomation() {
        return vehicleInfomationList;
    }

    public void addVehicleInfomation(VehicleInfomation NewVehicleInfomation) {
        vehicleInfomationList.add(NewVehicleInfomation);
    }

    public void updateVehicleInfomation(String bienSoXe, VehicleInfomation NewVehicleInfomation) {
        for (int i = 0; i < vehicleInfomationList.size(); i++) {
            if (vehicleInfomationList.get(i).bienSoXe().toUpperCase().equals(bienSoXe)) {
                vehicleInfomationList.set(i, NewVehicleInfomation);
                return;
            }
        }
    }

    public void removeVehicleInfomation(String bienSoXe) {
        vehicleInfomationList.removeIf(t -> t.bienSoXe().toUpperCase().equals(bienSoXe));
    }

    public List<VehicleInfomation> SeachBienSoXe(String bienSoXe) {
        return vehicleInfomationList.stream().filter(t -> t.bienSoXe().toUpperCase().equals(bienSoXe)).toList();
    }


    public List<VehicleInfomation> SeachSoChoNgoi(int soChoNgoi) {
        return vehicleInfomationList.stream().filter(t -> t.soChoNgoi() == (soChoNgoi)).toList();
    }

    public List<VehicleInfomation> SeachTheoNamSX(String namSX) {
        return vehicleInfomationList.stream().filter(t -> t.ngaySanXuat().getYear() == Integer.parseInt(namSX)).toList();
    }
}
