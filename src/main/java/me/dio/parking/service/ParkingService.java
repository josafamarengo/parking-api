package me.dio.parking.service;

import me.dio.parking.exception.ParkingNotFoundException;
import me.dio.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id1 = getUUID();
        var id2 = getUUID();
        Parking parking1 = new Parking(id1, "ABC-1234", "SP", "Fiat Uno", "Black");
        Parking parking2 = new Parking(id2, "DEF-5678", "SP", "VW Gol", "Red");
        parkingMap.put(id1, parking1);
        parkingMap.put(id2, parking2);
    }

    public List<Parking> findAll() {
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id) {
        Parking parking = parkingMap.get(id);
        if (parking == null) {
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }

    public Parking create(Parking parkingCreate) {
        var id = getUUID();
        parkingCreate.setId(id);
        parkingCreate.setEntryTime(LocalDateTime.now());
        parkingMap.put(id, parkingCreate);
        return parkingCreate;
    }
}
