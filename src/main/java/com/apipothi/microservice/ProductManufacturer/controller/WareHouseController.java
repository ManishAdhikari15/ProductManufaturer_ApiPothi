package com.apipothi.microservice.ProductManufacturer.controller;

import com.apipothi.microservice.ProductManufacturer.Utility.WarehouseUtility;
import com.apipothi.microservice.ProductManufacturer.dto.WareHouseReq;
import com.apipothi.microservice.ProductManufacturer.dto.WarehouseResponse;
import com.apipothi.microservice.ProductManufacturer.model.WarehouseProduct;
import com.apipothi.microservice.ProductManufacturer.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class WareHouseController {

    @Autowired
    private WarehouseService service;

    @PostMapping("/saveProduct")
    public List<WarehouseResponse> saveProduct(@RequestBody List<WareHouseReq> wareHouseReq){

        System.out.println("hello");
        String res=service.saveProduct(wareHouseReq);
        System.out.println("hello");
        List<WarehouseResponse> response = wareHouseReq.stream().map(WarehouseUtility::mapToResponse).collect(Collectors.toList());

        return response;

    }

    @GetMapping("/getAll")
    public List<WarehouseResponse> findAllProd(){
        List<WareHouseReq> allProducts = service.getAllProducts();
        List<WarehouseResponse> collect = allProducts.stream().map(WarehouseUtility::mapToResponse).collect(Collectors.toList());

        return collect;
    }

    @GetMapping("/get/{id}")
    public WarehouseResponse getProduct(@PathVariable("id") int id){

        Optional<WarehouseProduct> warehouseProduct = service.getProduct(id);

        System.out.println(warehouseProduct.isPresent());
        return new WarehouseResponse(warehouseProduct.get().getId(),warehouseProduct.get().getWproductId(),warehouseProduct.get().getWproductName(),warehouseProduct.get().getWproductPrice());
    }


    @PutMapping("/update/{id}")
    public String updateProd(@PathVariable("id") int id,@RequestBody WareHouseReq req){

        WarehouseProduct warehouseProduct = WarehouseUtility.MapToObj(req);

        String s = service.updateProduct(id, warehouseProduct);
        return s;

    }
}
