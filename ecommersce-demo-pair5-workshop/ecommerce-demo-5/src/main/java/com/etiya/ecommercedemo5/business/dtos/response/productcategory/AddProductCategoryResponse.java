package com.etiya.ecommercedemo5.business.dtos.response.productcategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class AddProductCategoryResponse {
    private int id;
    private int categoryId;
    private int productId;
}