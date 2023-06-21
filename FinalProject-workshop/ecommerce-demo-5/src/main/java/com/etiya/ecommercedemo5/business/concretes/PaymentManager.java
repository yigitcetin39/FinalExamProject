package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.PaymentService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.payment.AddPaymentRequest;
import com.etiya.ecommercedemo5.business.dtos.response.payment.AddPaymentResponse;
import com.etiya.ecommercedemo5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Payment;
import com.etiya.ecommercedemo5.entities.concretes.ProductCategory;
import com.etiya.ecommercedemo5.repository.abstracts.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private PaymentRepository paymentRepository;

    private ModelMapperService modelMapperService;
    private MessageSource messageSource;

    @Override
    public DataResult<List<Payment>> getAll() {
        List<Payment> response = this.paymentRepository.findAll();
        return new SuccessDataResult<List<Payment>>(response);
    }

    @Override
    public DataResult<Payment> getById(int id) {
        Payment response = this.paymentRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Payment>(response);
    }

    @Override
    public DataResult<AddPaymentResponse> addPayment(AddPaymentRequest addPaymentRequest) {

        paymentCanNotExistWithSameName(addPaymentRequest.getName());
        // MAPPING => AUTO MAPPER

        Payment payment =
                modelMapperService.getMapper().map(addPaymentRequest,Payment.class);
        AddPaymentResponse addPaymentResponse =
                modelMapperService.getMapper().map(paymentRepository.save(payment),AddPaymentResponse.class);
        return new SuccessDataResult<AddPaymentResponse>(addPaymentResponse);
    }

    private void paymentCanNotExistWithSameName(String name){

        boolean isExists = paymentRepository.existsCargoByName(name);
        if(isExists) // Veritabanımda bu isimde bir ödeme yöntemi mevcut!!

            throw new BusinessException(messageSource.getMessage(Messages.Payment.PaymentExistsWithSameName,null,
                    LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Page<Payment>> findAllWithPagination(Pageable pageable) {
        Page<Payment> response = this.paymentRepository.findAll(pageable);
        return new SuccessDataResult<Page<Payment>>(response,messageSource.getMessage(Messages.Payment.getByPage,null,LocaleContextHolder.getLocale()));
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
