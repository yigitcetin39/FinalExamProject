package com.etiya.ecommercedemo5.business.dtos.request.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddCategoryRequest {
    @Size(min = 3,max = 50,message = "yeterli karakter kullanmalısınız.")
    @NotNull(message = "Kategori ismi boş olamaz.")
    @NotBlank(message = "Kategori ismi boş olamaz.")
    private String name;
    private String type;
}
