package com.apipothi.microservice.ProductManufacturer.service;

import com.apipothi.microservice.ProductManufacturer.Utility.WarehouseUtility;
import com.apipothi.microservice.ProductManufacturer.dto.WareHouseReq;
import com.apipothi.microservice.ProductManufacturer.model.WarehouseProduct;
import com.apipothi.microservice.ProductManufacturer.repository.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepo dao;

    public String saveProduct(List<WareHouseReq> warehouseReq){
       // List<WarehouseProduct> warehouseprodList=new ArrayList<>();
        List<WarehouseProduct> warehouseReq1 =
        warehouseReq.stream().map(WarehouseUtility::MapToObj).collect(Collectors.toList());
        dao.saveAll(warehouseReq1);
        return "Saved Successfully";
    }

    public List<WareHouseReq> getAllProducts(){

        List<WarehouseProduct> allproducts = dao.findAll();

        List<WareHouseReq> requestObjList = allproducts.stream().map(WarehouseUtility::mapToRequest).collect(Collectors.toList());
        return requestObjList;
    }

    public Optional<WarehouseProduct> getProduct(int id){
        Optional<WarehouseProduct> bywproductName = dao.findById(id);
        System.out.println(bywproductName.isPresent());
        return bywproductName;

    }

    public String updateProduct(int id,WarehouseProduct prod){

        Optional<WarehouseProduct> product = dao.findById(id);

        if(product.isPresent()){
        product.get().setId(prod.getId());
        product.get().setWproductName(prod.getWproductName());
        product.get().setWproductId(prod.getWproductId());
        product.get().setWproductPrice(prod.getWproductPrice());

            dao.save(product.get());
            return "Product updated Successfully";
        }


        return "Not Updated ";

    }




}
