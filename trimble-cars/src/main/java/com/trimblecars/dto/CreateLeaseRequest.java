package com.trimblecars.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateLeaseRequest {

    @NotNull(message = "Customer ID is required")
    private Long customerId;

    @NotNull(message = "Car ID is required")
    private Long carId;
}
