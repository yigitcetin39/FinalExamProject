package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.ColorService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.color.AddColorRequest;
import com.etiya.ecommercedemo5.business.dtos.response.color.AddColorResponse;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Color;
import com.etiya.ecommercedemo5.repository.abstracts.ColorRepository;
import lombok.AllArgsConstructor;
import org.aspectj.apache.bcel.generic.MethodGen;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    private ColorRepository colorRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<Color>> getAll() {
        List<Color> response = this.colorRepository.findAll();
        // SAYFALAMA
        // FİLTRELEME
        return new SuccessDataResult<List<Color>>(response, Messages.Color.getAllColor);
    }

    @Override
    public DataResult<Color> getById(int id) {
        Color response = this.colorRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Color>(response, Messages.Color.getByColorId);
    }

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
    @Override
    public DataResult<AddColorResponse> addColor(AddColorRequest addColorRequest) {
        // MAPPING => AUTO MAPPER
        /*Color color = new Color();
        color.setName(addColorRequest.getName());

        //
        // Business Rules
        // Validation
        Color savedColor = colorRepository.save(color);

        // MAPPING -> Category => AddCategoryResponse
        AddColorResponse response =
                new AddColorResponse(savedColor.getId(), savedColor.getName());
        //
        return response;*/

        // MAPPING => AUTO MAPPER
        Color color =
                modelMapperService.getMapper().map(addColorRequest,Color.class);
        AddColorResponse addColorResponse =
                modelMapperService.getMapper().map(colorRepository.save(color),AddColorResponse.class);
        return new SuccessDataResult<AddColorResponse>(addColorResponse,Messages.Color.addColor);
    }
}
