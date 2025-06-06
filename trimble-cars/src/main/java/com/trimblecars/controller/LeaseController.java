package com.trimblecars.controller;

import com.trimblecars.dto.CreateLeaseRequest;
import com.trimblecars.dto.LeaseDTO;
import com.trimblecars.service.LeaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leases")
@RequiredArgsConstructor
public class LeaseController {

    private final LeaseService leaseService;

    @PostMapping
    public ResponseEntity<LeaseDTO> createLease(@Valid @RequestBody CreateLeaseRequest request) {
        return ResponseEntity.ok(leaseService.createLease(request));
    }

    @PutMapping("/api/leases/{id}/end")
    public ResponseEntity<?> endLease(@PathVariable Long id) {
        leaseService.endLease(id);
        return ResponseEntity.ok("Lease ended successfully");
    }



    @GetMapping
    public ResponseEntity<List<LeaseDTO>> getAllLeases() {
        return ResponseEntity.ok(leaseService.getAllLeases());
    }
}
