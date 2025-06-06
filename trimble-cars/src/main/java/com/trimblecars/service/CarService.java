package com.trimblecars.service;

import com.trimblecars.dto.CarDTO;
import com.trimblecars.dto.CreateCarRequest;
import com.trimblecars.entity.CarStatus;

import java.util.List;
import java.util.stream.Collectors;

public interface CarService {
    CarDTO registerCar(CreateCarRequest request);
    List<CarDTO> getAllCars();
   
  
    //List<CarDTO> getCarsByStatus(String status);
    
    public List<CarDTO> getCarsByStatus(String status);



}
