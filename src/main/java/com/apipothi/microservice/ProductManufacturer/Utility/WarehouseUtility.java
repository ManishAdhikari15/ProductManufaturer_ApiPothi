package com.apipothi.microservice.ProductManufacturer.Utility;

import com.apipothi.microservice.ProductManufacturer.dto.WareHouseReq;
import com.apipothi.microservice.ProductManufacturer.dto.WarehouseResponse;
import com.apipothi.microservice.ProductManufacturer.model.WarehouseProduct;

public class WarehouseUtility {

    public static WarehouseProduct MapToObj(WareHouseReq req){

        WarehouseProduct prod=new WarehouseProduct(req.getId(),req.getWproductid(),req.getWproductname(),req.getWproductprice());

        return prod;
    }

    public static WarehouseResponse mapToResponse(WareHouseReq wareHouseReqs){

        WarehouseResponse res=new WarehouseResponse(wareHouseReqs.getId(),wareHouseReqs.getWproductid(),wareHouseReqs.getWproductname(),wareHouseReqs.getWproductprice());
        return res;

    }

    public static WareHouseReq mapToRequest(WarehouseProduct prod){
        WareHouseReq req=new WareHouseReq(prod.getId(),prod.getWproductId(),prod.getWproductName(),prod.getWproductPrice());

        return req;

    }
}
