package com.apipothi.microservice.ProductManufacturer.repository;

import com.apipothi.microservice.ProductManufacturer.model.WarehouseProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepo extends JpaRepository<WarehouseProduct,Integer> {
}
