package com.etiya.ecommercedemo5.business.dtos.request.product;

import com.etiya.ecommercedemo5.entities.concretes.ColorSizeRelation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddProductRequest {
    private String name;
    @Min(value=1,message = "Ürün değeri  1'den küçük olamaz.")
    private double unitPrice;
    @Min(value = 0,message = "Stok adeti 0'dan küçük olamaz")
    //stock 0 olamaz(validasyon)
    private double stock;
    @Positive(message = "Colorsizeid positive olmalıdır!")
    private int colorsizeid;

}
