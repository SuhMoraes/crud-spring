package com.suhmoraes.javaspringexpert.entities.cars;

import com.suhmoraes.javaspringexpert.entities.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_cars_models")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@Setter
public class CarModels implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String drivetrain;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant date;

    @ManyToMany
    @JoinTable(name = "tb_cars_category",
            joinColumns = @JoinColumn(name = "cars_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Category> categories = new HashSet<>();

}
