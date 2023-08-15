package com.suhmoraes.javaspringexpert.dto;

import com.suhmoraes.javaspringexpert.entities.cars.CarModels;
import com.suhmoraes.javaspringexpert.entities.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarModelsDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String brand;
    private String model;
    private Integer production_year;
    private Double price;
    private String engineType;
    private Double engineDisplacement;
    private Integer horsepower;
    private Double torque;
    private Double topSpeed;
    private Double acceleration;
    private String transmission;
    private Double fuelEconomyCity;
    private Double fuelEconomyHighway;
    private Double curbWeight;
    private String dimensions;

    private Instant date;

    private List<CategoryDTO> categories = new ArrayList<>();

    public CarModelsDTO(CarModels entity) {

        this.id = entity.getId();
        this.brand = entity.getBrand();
        this.model = entity.getModel();
        this.production_year = entity.getProduction_year();
        this.price = entity.getPrice();
        this.engineType = entity.getEngineType();
        this.engineDisplacement = entity.getEngineDisplacement();
        this.horsepower = entity.getHorsepower();
        this.torque = entity.getTorque();
        this.topSpeed = entity.getTopSpeed();
        this.acceleration = entity.getAcceleration();
        this.transmission = entity.getTransmission();
        this.fuelEconomyCity = entity.getFuelEconomyCity();
        this.fuelEconomyHighway = entity.getFuelEconomyHighway();
        this.curbWeight = entity.getCurbWeight();
        this.dimensions = entity.getDimensions();
        this.date = entity.getDate();
    }

    public CarModelsDTO(CarModels entity, Set<Category> categories) {
        this(entity);
        categories.forEach( cat -> this.categories.add(new CategoryDTO(cat)));
    }
}
