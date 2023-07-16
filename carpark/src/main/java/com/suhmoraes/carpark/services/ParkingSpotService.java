package com.suhmoraes.carpark.services;

import com.suhmoraes.carpark.dtos.ParkingSpotDTO;
import com.suhmoraes.carpark.models.ParkingSpotModel;
import com.suhmoraes.carpark.repositories.ParkingSportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSpotService {

    @Autowired
    private ParkingSportRepository repository;


    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return repository.save(parkingSpotModel);
    }


    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return repository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return repository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartamentAndBlock(String apartament, String block) {
       return repository.existsByApartamentAndBlock(apartament,block);
    }

    public List<ParkingSpotModel> findAll() {
        return repository.findAll();
    }
}
