package com.revature.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
    Takes in the product from the UI
 */
@Data
public class ProductDTO
{
    private String name;
    private String description;
    private BigDecimal price;
    private String category;//category id as a string from frontend

}
