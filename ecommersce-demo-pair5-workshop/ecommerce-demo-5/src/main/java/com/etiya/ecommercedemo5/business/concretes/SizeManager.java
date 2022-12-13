package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.SizeService;

import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.size.AddSizeRequest;
import com.etiya.ecommercedemo5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo5.business.dtos.response.size.AddSizeResponse;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Size;

import com.etiya.ecommercedemo5.repository.abstracts.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SizeManager implements SizeService {

    private SizeRepository sizeRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<List<Size>> getAll() {
        List<Size> response = sizeRepository.findAll();
        return new SuccessDataResult<List<Size>>(response, Messages.Size.getAllSize);
    }

    @Override
    public DataResult<Size> getById(int id) {
        Size response = this.sizeRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Size>(response,Messages.Size.getBySizeId);
    }

    @Override
    public DataResult<List<Size>> getAllByStockGreaterThan(int stock) {
        List<Size> response = this.sizeRepository.findAllSizesByStockGreaterThanOrderByStockDesc(stock);
        return new SuccessDataResult<List<Size>>(response,Messages.Size.getBySizeGreaterThanStock);
    }

    @Override
    public DataResult<Size> getByName(String name) {
        Size response = this.sizeRepository.findByName(name);
        return new SuccessDataResult<Size>(response,Messages.Size.getBySizeName);
    }

    @Override
    public DataResult<AddSizeResponse> addSize(AddSizeRequest addSizeRequest) {
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
        return new SuccessDataResult<AddSizeResponse>(addSizeResponse,Messages.Size.addSize);

    }
}
