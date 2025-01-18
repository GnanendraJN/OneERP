package org.oneerp.product.dto;

import lombok.Data;

import javax.measure.Unit;

@Data
public class ProductTO {
    private String id;
    private String name;
    private String measurement;
    //Unit<?> measurement;
    private float price;
}
