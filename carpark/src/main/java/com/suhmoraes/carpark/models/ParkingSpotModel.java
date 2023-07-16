package com.suhmoraes.carpark.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;

    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;

    @Column(nullable = false, unique = true, length = 70)
    private String brand;

    @Column(nullable = false, length = 70)
    private  String modelCar;

    @Column(nullable = false, length = 70)
    private String colorCar;

    @Column(nullable = false)
    private LocalDateTime resgistrationDate;

    @Column(nullable = false, length = 130)
    private String responsibleName;

    @Column(nullable = false, length = 30)
    private String apartament;

    @Column(nullable = false, length = 30)
    private String block;

    public ParkingSpotModel() {
    }

    public ParkingSpotModel(UUID id, String parkingSpotNumber, String licensePlateCar, String brand, String modelCar,
                            String colorCar, LocalDateTime resgistrationDate, String responsibleName, String apartament,
                            String block) {
        this.id = id;
        this.parkingSpotNumber = parkingSpotNumber;
        this.licensePlateCar = licensePlateCar;
        this.brand = brand;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.resgistrationDate = resgistrationDate;
        this.responsibleName = responsibleName;
        this.apartament = apartament;
        this.block = block;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public LocalDateTime getResgistrationDate() {
        return resgistrationDate;
    }

    public void setResgistrationDate(LocalDateTime resgistrationDate) {
        this.resgistrationDate = resgistrationDate;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartament() {
        return apartament;
    }

    public void setApartament(String apartament) {
        this.apartament = apartament;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
