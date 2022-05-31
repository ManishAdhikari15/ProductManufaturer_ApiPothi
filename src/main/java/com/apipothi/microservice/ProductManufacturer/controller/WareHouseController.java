package com.apipothi.microservice.ProductManufacturer.controller;

import com.apipothi.microservice.ProductManufacturer.dto.WareHouseReq;
import com.apipothi.microservice.ProductManufacturer.dto.WarehouseResponse;
import com.apipothi.microservice.ProductManufacturer.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WareHouseController {

    @Autowired
    private WarehouseService service;

    @PostMapping
    public List<WarehouseResponse> saveProduct(List<WareHouseReq> wareHouseReqs){

        String res=service.saveProduct(wareHouseReqs);

        List<WarehouseResponse> response = wareHouseReqs.stream().map(WareHouseController::mapToResponse).collect(Collectors.toList());

        return response;

    }

    public static WarehouseResponse mapToResponse(WareHouseReq wareHouseReqs){

        WarehouseResponse res=new WarehouseResponse(wareHouseReqs.getId(),wareHouseReqs.getWproductid(),wareHouseReqs.getWproductname(),wareHouseReqs.getWproductprice());
        return res;

    }
}
