package me.dio.parking.model;

import java.time.LocalDateTime;

public class Parking {

    private String id;
    private String license;
    private String state;
    private String model;
    private String color;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private int parkingTimeInMinutes;
    private Double parkingCost;

    public Parking(String id, String license, String state, String model, String color) {
        this.id = id;
        this.license = license;
        this.state = state;
        this.model = model;
        this.color = color;
    }

    public Parking() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public int getParkingTimeInMinutes() {
        return parkingTimeInMinutes;
    }

    public void setParkingTimeInMinutes() {
        var hours = exitTime.getHour() - entryTime.getHour();
        var minutes = exitTime.getMinute() - entryTime.getMinute();
        this.parkingTimeInMinutes = (hours * 60) + minutes;
    }

    public Double getParkingCost() {
        return parkingCost;
    }

    public void setParkingCost() {
        /* 1 hour = 5 reais
         * <= 15 minutes = 0 reais
         * > 15 minutes = 5 reais
         * */
        if (parkingTimeInMinutes <= 15) {
            this.parkingCost = 0.00;
        } else {
            this.parkingCost = Math.ceil(parkingTimeInMinutes / 60.0) * 5;
        }
    }
}
