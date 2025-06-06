package com.trimblecars.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCarRequest {

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "Number plate is required")
    private String numberPlate;

    @NotNull(message = "Owner ID is required")
    private Long ownerId;
}
