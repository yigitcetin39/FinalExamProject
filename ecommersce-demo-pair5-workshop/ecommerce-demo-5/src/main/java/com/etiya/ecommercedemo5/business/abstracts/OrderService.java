package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemo5.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommercedemo5.entities.concretes.Order;

import java.sql.Date;
import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order getById(int id);
    List<Order> getByOrderDate(Date orderDate);

    List<Order> getALlOrderByCargoCompany(String cargoCompany);

    /*  DataResult<List<OrderDTO>> getAddressTitlesOfOrders();*/

    AddOrderResponse addOrder(AddOrderRequest addOrderRequest);

}
