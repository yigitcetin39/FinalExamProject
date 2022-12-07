package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.SizeService;

import com.etiya.ecommercedemo5.business.dtos.request.size.AddSizeRequest;
import com.etiya.ecommercedemo5.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo5.business.dtos.response.size.AddSizeResponse;
import com.etiya.ecommercedemo5.entities.concretes.Size;

import com.etiya.ecommercedemo5.repository.abstracts.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SizeManager implements SizeService {

    private SizeRepository sizeRepository;
    @Override
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getById(int id) {
        return sizeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Size> getAllByStockGreaterThan(int stock) {
        return sizeRepository.findAllSizesByStockGreaterThanOrderByStockDesc(stock);
    }

    @Override
    public Size getByName(String name) {
        return sizeRepository.findByName(name);
    }

    @Override
    public AddSizeResponse addSize(AddSizeRequest addSizeRequest) {
        Size size = new Size();
        size.setName(addSizeRequest.getName());
        size.setStock(addSizeRequest.getStock());
        Size savedSize = sizeRepository.save(size);

        AddSizeResponse response = new AddSizeResponse(savedSize.getId(), savedSize.getName(), savedSize.getStock());
        return response;

    }
}
