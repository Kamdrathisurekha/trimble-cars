package com.trimblecars.service.impl;

import com.trimblecars.dto.CreateLeaseRequest;
import com.trimblecars.dto.LeaseDTO;
import com.trimblecars.entity.*;
import com.trimblecars.repository.*;
import com.trimblecars.service.LeaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import com.trimblecars.exception.BadRequestException;
import com.trimblecars.exception.ResourceNotFoundException;


@Service
@RequiredArgsConstructor
public class LeaseServiceImpl implements LeaseService {

    private final LeaseRepository leaseRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    @Override
    public LeaseDTO createLease(CreateLeaseRequest request) {
        User customer = userRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

       
        if (leaseRepository.countByCustomerAndEndTimeIsNull(customer) >= 2) {
            throw new BadRequestException("Customer has already leased 2 cars");
        }


        Car car = carRepository.findById(request.getCarId())
                .orElseThrow(() -> new ResourceNotFoundException("Car not found"));

        if (car.getStatus() != CarStatus.IDLE) {
            throw new BadRequestException("Car is not available for leasing");
        }


        Lease lease = new Lease();
        lease.setCar(car);
        lease.setCustomer(customer);
        lease.setStartTime(LocalDateTime.now());

        car.setStatus(CarStatus.ON_LEASE);
        carRepository.save(car);

        return mapToDTO(leaseRepository.save(lease));
    }

    @Override
    public LeaseDTO endLease(Long leaseId) {
        Lease lease = leaseRepository.findById(leaseId)
                .orElseThrow(() -> new RuntimeException("Lease not found"));

        lease.setEndTime(LocalDateTime.now());

        Car car = lease.getCar();
        car.setStatus(CarStatus.IDLE);
        carRepository.save(car);

        return mapToDTO(leaseRepository.save(lease));
    }

    @Override
    public List<LeaseDTO> getAllLeases() {
        return leaseRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private LeaseDTO mapToDTO(Lease lease) {
        LeaseDTO dto = new LeaseDTO();
        dto.setId(lease.getId());
        dto.setCustomerName(lease.getCustomer().getName());
        dto.setCarModel(lease.getCar().getModel());
        dto.setNumberPlate(lease.getCar().getNumberPlate());
        dto.setStartTime(lease.getStartTime());
        dto.setEndTime(lease.getEndTime());
        return dto;
    }
}
