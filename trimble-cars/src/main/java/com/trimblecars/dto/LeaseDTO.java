package com.trimblecars.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LeaseDTO {
    private Long id;
    private String customerName;
    private String carModel;
    private String numberPlate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}

