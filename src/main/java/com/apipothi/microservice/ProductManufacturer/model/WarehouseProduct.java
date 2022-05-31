package com.apipothi.microservice.ProductManufacturer.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "warehouse_product_tbl")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WarehouseProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String wproductId;
    private String wproductName;
    private long wproductPrice;
}
