package com.trimblecars.repository;

import com.trimblecars.entity.Lease;
import com.trimblecars.entity.Car;
import com.trimblecars.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaseRepository extends JpaRepository<Lease, Long> {
    List<Lease> findByCustomer(User customer);
    List<Lease> findByCar(Car car);
    long countByCustomerAndEndTimeIsNull(User customer); // To limit 2 active leases
}
