package com.trimblecars.controller;

import com.trimblecars.dto.CarDTO;
import com.trimblecars.dto.CreateCarRequest;
import com.trimblecars.entity.CarStatus;
import com.trimblecars.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

 
    @PostMapping
    public ResponseEntity<CarDTO> registerCar(@Valid @RequestBody CreateCarRequest request) {
        return ResponseEntity.ok(carService.registerCar(request));
    }


    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<CarDTO>> getCarsByStatus(@PathVariable("status") CarStatus status) {
        return ResponseEntity.ok(carService.getCarsByStatus(status.name()));
    }

}
