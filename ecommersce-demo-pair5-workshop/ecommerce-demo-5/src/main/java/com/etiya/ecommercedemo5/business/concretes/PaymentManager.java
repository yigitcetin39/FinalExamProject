package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.PaymentService;
import com.etiya.ecommercedemo5.business.dtos.request.payment.AddPaymentRequest;
import com.etiya.ecommercedemo5.business.dtos.response.payment.AddPaymentResponse;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.entities.concretes.Payment;
import com.etiya.ecommercedemo5.repository.abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private PaymentRepository paymentRepository;

    private ModelMapperService modelMapperService;

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(int id) {
        return paymentRepository.findById(id).orElseThrow();
    }

    @Override
    public AddPaymentResponse addPayment(AddPaymentRequest addPaymentRequest) {
        // MAPPING => AUTO MAPPER

        Payment payment =
                modelMapperService.getMapper().map(addPaymentRequest,Payment.class);
        AddPaymentResponse addPaymentResponse =
                modelMapperService.getMapper().map(paymentRepository.save(payment),AddPaymentResponse.class);
        return addPaymentResponse;
    }
}

/*Payment payment = new Payment();
    MoneyType moneyType = moneyTypeService.getById(addPaymentRequest.getMoneytypeid());
        payment.setMoneyType(moneyType);
                //
                // Business Rules
                // Validation
                Payment savedPayment = paymentRepository.save(payment);
                // MAPPING -> Category => AddCategoryResponse
                AddPaymentResponse response =
                new AddPaymentResponse(savedPayment.getId(),savedPayment.getMoneyType().getId());
                return response;*/
