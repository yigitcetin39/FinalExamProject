package com.etiya.ecommercedemo5.repository.abstracts;

import com.etiya.ecommercedemo5.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByOrderDate(java.sql.Date orderDate);

    // Yazılan kargo şirketinin  siparişleri getir
    @Query(value =  "select * from orders o inner join cargo c on c.id = o.cargoid where c.name like %:cargoCompany%", nativeQuery = true)
    List<Order> getALlOrderByCargoCompany(String cargoCompany);

   /* @Query(value = "SELECT new com.etiya.ecommerscedemopair5.business.dtos.OrderDTO(at.name)" +
            "FROM orders as o\n" +
            "right join address a\n" +
            "on o.addressid=a.id\n" +
            "inner join addresstitle at\n" +
            "on at.id=a.addresstitleid\n" +
            "WHERE o.id>0\n" +
            "GROUP BY at.name")
    List<OrderDTO> getAddressTitlesOfOrders();
*/
}
