package com.trimblecars.service.impl;

import com.trimblecars.dto.CarDTO;
import com.trimblecars.dto.CreateCarRequest;
import com.trimblecars.entity.Car;
import com.trimblecars.entity.CarStatus;
import com.trimblecars.entity.User;
import com.trimblecars.exception.ResourceNotFoundException;
import com.trimblecars.repository.CarRepository;
import com.trimblecars.repository.UserRepository;
import com.trimblecars.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final UserRepository userRepository;

    @Override
    public CarDTO registerCar(CreateCarRequest request) {
        User owner = userRepository.findById(request.getOwnerId())
        		.orElseThrow(() -> new ResourceNotFoundException("Owner not found"));


        Car car = new Car();
        car.setModel(request.getModel());
        car.setNumberPlate(request.getNumberPlate());
        car.setStatus(CarStatus.IDLE);
        car.setOwner(owner);

        return mapToDTO(carRepository.save(car));
    }

    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDTO> getCarsByStatus(String status) {
        CarStatus carStatus = CarStatus.valueOf(status.toUpperCase());
        return carRepository.findByStatus(carStatus).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private CarDTO mapToDTO(Car car) {
        CarDTO dto = new CarDTO();
        dto.setId(car.getId());
        dto.setModel(car.getModel());
        dto.setNumberPlate(car.getNumberPlate());
        dto.setStatus(car.getStatus());
        dto.setOwnerName(car.getOwner().getName());
        return dto;
    }
}
