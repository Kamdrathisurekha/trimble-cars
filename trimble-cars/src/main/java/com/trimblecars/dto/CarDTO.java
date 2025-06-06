package com.trimblecars.dto;

import com.trimblecars.entity.CarStatus;
import lombok.Data;

@Data
public class CarDTO {
    private Long id;
    private String model;
    private String numberPlate;
    private CarStatus status;
    private String ownerName;
}
