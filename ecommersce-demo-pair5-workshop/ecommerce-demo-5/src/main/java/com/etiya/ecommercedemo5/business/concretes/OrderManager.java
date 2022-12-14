package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.OrderService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemo5.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommercedemo5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Order;
import com.etiya.ecommercedemo5.repository.abstracts.*;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {

    private OrderRepository orderRepository;

    private ModelMapperService modelMapperService;
    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;
    private PaymentRepository paymentRepository;
    private CargoRepository cargoRepository;
    private ProductRepository productRepository;
    private MessageSource messageSource;

   /* private CustomerService customerService;
    private AddressService addressService;
    private PaymentService paymentService;
    private CargoService cargoService;
    private ProductService productService;*/

    @Override
    public DataResult<List<Order>> getAll() {
        List<Order> response = this.orderRepository.findAll();
        return new SuccessDataResult<List<Order>>(response, messageSource.getMessage(Messages.Order.getAllOrder,null,LocaleContextHolder.getLocale()));
    }
    @Override
    public DataResult<Order> getById(int id) {
        Order response = this.orderRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Order>(response,messageSource.getMessage(Messages.Order.getByOrderId,null,LocaleContextHolder.getLocale()));
    }
    @Override
    public DataResult<List<Order>> getByOrderDate(Date orderDate) {
        List<Order> response = this.orderRepository.findByOrderDate(orderDate);
        return new SuccessDataResult<List<Order>>(response,messageSource.getMessage(Messages.Order.getOrderDate,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<List<Order>> getALlOrderByCargoCompany(String cargoCompany) {
        String cargoComp = cargoCompany.toLowerCase();
        List<Order> response = this.orderRepository.getALlOrderByCargoCompany(cargoCompany);
        return new SuccessDataResult<List<Order>>(response,messageSource.getMessage(Messages.Order.getAllOrderByCargoCompany,null,LocaleContextHolder.getLocale()));
    }

   /* @Override
    public DataResult<List<OrderDTO>> getAddressTitlesOfOrders() {
        return new SuccessDataResult<>(orderRepository.getAddressTitlesOfOrders());
    }*/


    @Override
    public DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest) {

        checkIfExistsProductId(addOrderRequest.getProductId());
        checkIfExistsCargoId(addOrderRequest.getCargoId());
        checkIfExistsPaymentId(addOrderRequest.getPaymentId());
        checkIfExistsAddressId(addOrderRequest.getAddressId());
        checkIfExistsCustomerId(addOrderRequest.getCustomerId());


        Order order = modelMapperService.getMapper().map(addOrderRequest,Order.class);
        AddOrderResponse addOrderResponse =
                modelMapperService.getMapper().map(orderRepository.save(order),AddOrderResponse.class);
        return new SuccessDataResult<AddOrderResponse>(addOrderResponse,messageSource.getMessage(Messages.Order.addOrder,null,LocaleContextHolder.getLocale()));
    }

    public void checkIfExistsCustomerId(int id){
        boolean isExists = customerRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(messageSource.getMessage(Messages.Customer.runTimeException,null, LocaleContextHolder.getLocale()));
        }
    }

    public void checkIfExistsAddressId(int id){
        boolean isExists = addressRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(messageSource.getMessage(Messages.Address.runTimeException,null, LocaleContextHolder.getLocale()));
        }
    }

    public void checkIfExistsPaymentId(int id){
        boolean isExists = paymentRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(messageSource.getMessage(Messages.Payment.runTimeException,null, LocaleContextHolder.getLocale()));
        }
    }

    public void checkIfExistsCargoId(int id){
        boolean isExists = cargoRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(messageSource.getMessage(Messages.Cargo.runTimeExceptionCargo,null, LocaleContextHolder.getLocale()));
        }
    }

    public void checkIfExistsProductId(int id){
        boolean isExists = productRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(messageSource.getMessage(Messages.Product.runTimeException,null, LocaleContextHolder.getLocale()));
        }
    }

}

/*
    Order order = new Order();
        order.setDate(addOrderRequest.getDate());
       // order.setInvoices(addOrderRequest.getOrderid()); !''+'+'+'+'+'+'+
        Customer customer = customerService.getById(addOrderRequest.getCustomerid());
        order.setCustomers(customer);
        Address address= addressService.getById(addOrderRequest.getAddressid());
        order.setAddress(address);
        Payment payment=paymentService.getById(addOrderRequest.getPaymentid());
        order.setPayment(payment);
        Cargo cargo = cargoService.getById(addOrderRequest.getCargoid());
        order.setCargo(cargo);
        Product product = productService.getById(addOrderRequest.getProductid());
        order.setProduct(product);
        Order savedOrder=orderRepository.save(order);
        AddOrderResponse response = new AddOrderResponse(savedOrder.getId(),
                savedOrder.getDate(),
                savedOrder.getCustomers().getId(),
                savedOrder.getAddress().getId(),
                savedOrder.getPayment().getId(),
                savedOrder.getCargo().getId(),
                savedOrder.getProduct().getId());
        return response;
     */
