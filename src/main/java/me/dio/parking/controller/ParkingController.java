package me.dio.parking.controller;

import me.dio.parking.model.Parking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class ParkingController {

    @GetMapping("/parking")
    public List<Parking> findAll() {

        var parking1 = new Parking();
        parking1.setLicense("ABC-1234");
        parking1.setState("SP");
        parking1.setModel("Fiat Uno");
        parking1.setColor("Black");
        parking1.setEntryTime(LocalDateTime.now());

        return Arrays.asList(parking1, parking1);
    }
}
