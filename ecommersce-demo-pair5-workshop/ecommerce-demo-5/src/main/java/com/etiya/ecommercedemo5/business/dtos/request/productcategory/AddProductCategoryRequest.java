package com.etiya.ecommercedemo5.business.dtos.request.productcategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class AddProductCategoryRequest {
    private int categoryId;
    private int productId;
    //bunlar maplemek için productId diye yazacağız!!!!!

}