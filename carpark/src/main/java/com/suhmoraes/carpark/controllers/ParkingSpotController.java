package com.suhmoraes.carpark.controllers;

import com.suhmoraes.carpark.dtos.ParkingSpotDTO;
import com.suhmoraes.carpark.models.ParkingSpotModel;
import com.suhmoraes.carpark.services.ParkingSpotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins ="*", maxAge = 3600)
@RequestMapping(value = "/car-park", produces = {"application/json"})
@Tag(name = "car-park")
@Slf4j
public class ParkingSpotController {

    @Autowired
    private ParkingSpotService parkingSpotService;


    @Operation(summary = "Salva dados Parking Spot ", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Dados salvos com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar Parking Spot."),
    })
    @PostMapping(value = " ", name = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO) {
        if(parkingSpotService.existsByLicensePlateCar(parkingSpotDTO.getLicensePlateCar())) {
            log.info("CONFLICT: LICENSE PLATE CAR IS ALREADY IN USE!" + parkingSpotDTO.getLicensePlateCar());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
        }
        if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber())) {
            log.info("CONFLICT: PARKING SPOT NUMBER IS ALREADY IN USE!" + parkingSpotDTO.getParkingSpotNumber());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot Number is already in use!");
        }
        if(parkingSpotService.existsByApartamentAndBlock(parkingSpotDTO.getApartament(), parkingSpotDTO.getBlock())) {
            log.info("CONFLICT: PARKING SPOT ALREADY RESGISTRED!" + parkingSpotDTO.getApartament(), parkingSpotDTO.getBlock());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registred");
        }

        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);
        parkingSpotModel.setResgistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        log.info("CREATED ::: PARKING SPOT");
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }


    @Operation(summary = "Retorna todos os dados de Parking Spot.", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorno de todos os dados Parking Spot realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao retornar todos os Parking Spot."),
    })
    @GetMapping(value =" ",name="getall", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots() {
        log.info("FIND ALL ::: PARKING SPOT!" );
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
    }

    @Operation(summary = "Busca o Parking Spot por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização de dados Parking Spot com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a atualização de Parking Spot"),
    })
    @GetMapping(value="/{id}", name="get id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findByID(id);
        if(!parkingSpotModelOptional.isPresent()) {
            log.info("NOT FOUND ID ::: PARKING SPOT!" );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot Not found!");
        }
        log.info("OK, ID IS PRESENT ::: PARKING SPOT!" );
        return  ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
    }

    @Operation(summary = "Deleta Parking Spot por ID", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete de dados Parking Spot realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar Parking Spot"),
    })
    @DeleteMapping(value="/{id}",name="delete id" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteOneParkingSpot(@PathVariable(value = "id") UUID id) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findByID(id);
        if(!parkingSpotModelOptional.isPresent()) {
            log.info("NOT FOUND ID FOR DELETE ::: PARKING SPOT!" );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found!");
        }
        parkingSpotService.delete(parkingSpotModelOptional.get());
        log.info("DELETE FOR ID ::: PARKING SPOT!" );
        return  ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully!");
    }

    @Operation(summary = "Atualiza os dados de Parking Spot", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização de dados Parking Spot realizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar os dados de Parking Spot "),
    })
    @PutMapping(value="/{id}", name="Update id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid ParkingSpotDTO parkingSpotDTO){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findByID(id);
        if (!parkingSpotModelOptional.isPresent()) {
            log.info("NOT FOUND PUT ID ::: PARKING SPOT!" );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);
        parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
        parkingSpotModel.setResgistrationDate(parkingSpotModelOptional.get().getResgistrationDate());
        log.info("OK, PUT ID SUCCESS::: PARKING SPOT!" );
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
    }
}
