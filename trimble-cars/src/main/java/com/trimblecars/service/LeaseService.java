package com.trimblecars.service;

import com.trimblecars.dto.CreateLeaseRequest;
import com.trimblecars.dto.LeaseDTO;

import java.util.List;

public interface LeaseService {
    LeaseDTO createLease(CreateLeaseRequest request);
    
    List<LeaseDTO> getAllLeases();

	LeaseDTO endLease(Long leaseId);
}

