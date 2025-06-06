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

    // ✅ 1. Register a new car
    @PostMapping
    public ResponseEntity<CarDTO> registerCar(@Valid @RequestBody CreateCarRequest request) {
        return ResponseEntity.ok(carService.registerCar(request));
    }

    // ✅ 2. Get all cars
    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    // ✅ 3. Get cars by status (fix: @PathVariable("status"))
    @GetMapping("/status/{status}")
    public ResponseEntity<List<CarDTO>> getCarsByStatus(@PathVariable("status") CarStatus status) {
        return ResponseEntity.ok(carService.getCarsByStatus(status.name()));
    }

}
