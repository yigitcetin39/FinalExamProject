package com.etiya.ecommercedemo5.business.abstracts;

import com.etiya.ecommercedemo5.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemo5.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.entities.concretes.Order;
import com.etiya.ecommercedemo5.entities.concretes.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;

public interface OrderService {
    DataResult<List<Order>> getAll();
    DataResult<Order> getById(int id);
    DataResult<List<Order>> getByOrderDate(Date orderDate);

    DataResult<List<Order>> getALlOrderByCargoCompany(String cargoCompany);

    /*  DataResult<List<OrderDTO>> getAddressTitlesOfOrders();*/

    DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest);

    DataResult<Page<Order>> findAllWithPagination(Pageable pageable);

}
