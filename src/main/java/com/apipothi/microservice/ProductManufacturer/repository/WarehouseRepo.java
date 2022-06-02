package com.apipothi.microservice.ProductManufacturer.repository;

import com.apipothi.microservice.ProductManufacturer.model.WarehouseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseRepo extends JpaRepository<WarehouseProduct,Integer> {

    Optional<WarehouseProduct> findBywproductName(String name);
}
