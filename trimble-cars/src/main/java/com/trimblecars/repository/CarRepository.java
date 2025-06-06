package com.trimblecars.repository;

import com.trimblecars.entity.Car;
import com.trimblecars.entity.User;
import com.trimblecars.entity.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByOwner(User owner);
    List<Car> findByStatus(CarStatus status);
}

