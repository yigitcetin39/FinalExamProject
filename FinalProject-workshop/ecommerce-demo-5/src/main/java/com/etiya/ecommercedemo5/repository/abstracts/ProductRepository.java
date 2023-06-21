package com.etiya.ecommercedemo5.repository.abstracts;

import com.etiya.ecommercedemo5.business.dtos.ProductDTO;
import com.etiya.ecommercedemo5.entities.concretes.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    // Stock sayısına göre stock alanı gelen int değerden fazla olan productlar.

    // findAll-Products-By-Stock(int stock)
    // findAll-Products-By-Stock-GreaterThan(int stock)
    List<Product> findAllProductsByStockGreaterThanOrderByStockDesc(double stock);


    // default olarak native SQL DEĞİL!
    // JPQL
    // :parametreIsmi
    @Query("Select p from Product as p WHERE name=:name")
    Product findByName(String name);

    @Query("Select p from Product as p WHERE name=:prefix")
    List<Product> findByNameStartingWith(String prefix);


    List<Product> findByNameIgnoreCaseContaining(String name);

    List<Product> findByNameOrderByNameAsc(String name);

    @Query(value = "Select * from products where colorsizeid=:colorsizeid",nativeQuery = true)
    List<Product> findByExample(int colorsizeid);

    @Query("Select new com.etiya.ecommercedemo5.business.dtos.ProductDTO(p.id,p.name)" +
            " from Product p WHERE p.id=:id")
    List<ProductDTO> findByExampleProduct(int id);

    @Query("Select p from Product as p")
    Slice<Product> getAllWithSlice(Pageable pageable);

    boolean existsProductByName(String name);



}