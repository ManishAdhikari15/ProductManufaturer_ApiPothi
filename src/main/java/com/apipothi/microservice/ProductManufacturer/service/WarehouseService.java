package com.apipothi.microservice.ProductManufacturer.service;

import com.apipothi.microservice.ProductManufacturer.dto.WareHouseReq;
import com.apipothi.microservice.ProductManufacturer.model.WarehouseProduct;
import com.apipothi.microservice.ProductManufacturer.repository.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepo dao;

    public String saveProduct(List<WareHouseReq> warehouseReq){

        List<WarehouseProduct> warehouseprodList=new ArrayList<>();


        List<WarehouseProduct> warehouseReq1 =
        warehouseReq.stream().map(WarehouseService::MapToObj).collect(Collectors.toList());

        dao.saveAll(warehouseReq1);

        return "Saved Successfully";
    }

    public static WarehouseProduct MapToObj(WareHouseReq req){

        WarehouseProduct prod=new WarehouseProduct(req.getId(),req.getWproductid(),req.getWproductname(),req.getWproductprice());

        return prod;
    }


}
