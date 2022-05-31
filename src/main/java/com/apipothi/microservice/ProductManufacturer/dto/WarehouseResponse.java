package com.apipothi.microservice.ProductManufacturer.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseResponse {

    private int id;
    private String wproductid;
    private String wproductname;
    private long wproductprice;
}
