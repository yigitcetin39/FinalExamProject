package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.SizeService;

import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.size.AddSizeRequest;
import com.etiya.ecommercedemo5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo5.business.dtos.response.size.AddSizeResponse;
import com.etiya.ecommercedemo5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Product;
import com.etiya.ecommercedemo5.entities.concretes.Size;

import com.etiya.ecommercedemo5.repository.abstracts.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SizeManager implements SizeService {

    private SizeRepository sizeRepository;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;
    @Override
    public DataResult<List<Size>> getAll() {
        List<Size> response = sizeRepository.findAll();
        return new SuccessDataResult<List<Size>>(response, messageSource.getMessage(Messages.Size.getAllSize,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Size> getById(int id) {
        Size response = this.sizeRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Size>(response);
    }

    @Override
    public DataResult<List<Size>> getAllByStockGreaterThan(int stock) {
        List<Size> response = this.sizeRepository.findAllSizesByStockGreaterThanOrderByStockDesc(stock);
        return new SuccessDataResult<List<Size>>(response);
    }

    @Override
    public DataResult<Size> getByName(String name) {
        Size response = this.sizeRepository.findByName(name);
        return new SuccessDataResult<Size>(response);
    }

    @Override
    public DataResult<AddSizeResponse> addSize(AddSizeRequest addSizeRequest) {

        sizeCanNotExistWithSameName(addSizeRequest.getName());
        /*Size size = new Size();
        size.setName(addSizeRequest.getName());
        size.setStock(addSizeRequest.getStock());
        Size savedSize = sizeRepository.save(size);

        AddSizeResponse response = new AddSizeResponse(savedSize.getId(), savedSize.getName(), savedSize.getStock());
        return response;*/

        Size size =
                modelMapperService.getMapper().map(addSizeRequest,Size.class);
        AddSizeResponse addSizeResponse =
                modelMapperService.getMapper().map(sizeRepository.save(size),AddSizeResponse.class);
        return new SuccessDataResult<AddSizeResponse>(addSizeResponse,messageSource.getMessage(Messages.Size.addSize,null,LocaleContextHolder.getLocale()));

    }

    private void sizeCanNotExistWithSameName(String name){

        boolean isExists = sizeRepository.existsSizeByName(name);
        if(isExists) // Veritabanımda bu isimde bir kalıp mevcut!!

            throw new BusinessException(messageSource.getMessage(Messages.Size.SizeExistsWithSameName,null,
                    LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Page<Size>> findAllWithPagination(Pageable pageable) {
        Page<Size> response = this.sizeRepository.findAll(pageable);
        return new SuccessDataResult<Page<Size>>(response,messageSource.getMessage(Messages.Size.getByPage,null,LocaleContextHolder.getLocale()));
    }
}
