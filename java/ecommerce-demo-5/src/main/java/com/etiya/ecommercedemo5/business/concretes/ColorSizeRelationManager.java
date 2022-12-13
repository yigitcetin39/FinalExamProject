package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.ColorService;
import com.etiya.ecommercedemo5.business.abstracts.ColorSizeRelationService;
import com.etiya.ecommercedemo5.business.abstracts.SizeService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.colorsizerelation.AddColorSizeRelationRequest;
import com.etiya.ecommercedemo5.business.dtos.response.colorsizerelation.AddColorSizeRelationResponse;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Color;
import com.etiya.ecommercedemo5.entities.concretes.ColorSizeRelation;
import com.etiya.ecommercedemo5.entities.concretes.Size;
import com.etiya.ecommercedemo5.repository.abstracts.ColorSizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorSizeRelationManager implements ColorSizeRelationService {

    private ColorSizeRepository colorSizeRepository;
    private ModelMapperService modelMapperService;
    private ColorService colorService;
    @Override
    public DataResult<List<ColorSizeRelation>> getAll() {
        List<ColorSizeRelation> response = this.colorSizeRepository.findAll();
        return new SuccessDataResult<List<ColorSizeRelation>>(response, Messages.ColorSizeRelation.getAllColorSizeRelation);
    }

    @Override
    public DataResult<ColorSizeRelation> getById(int id) {
        ColorSizeRelation response = this.colorSizeRepository.findById(id).orElseThrow();
        return new SuccessDataResult<ColorSizeRelation>(response,Messages.ColorSizeRelation.getByColorSizeRelationId);
    }

    @Override
    public DataResult<AddColorSizeRelationResponse> addColorSizeRelation(AddColorSizeRelationRequest addColorSizeRelationRequest) {
        // MAPPING => AUTO MAPPER
        /*ColorSizeRelation colorSizeRelation = new ColorSizeRelation();

        Color color = colorService.getById(addColorSizeRelationRequest.getColorId());
        colorSizeRelation.setColor(color);

        Size size = sizeService.getById(addColorSizeRelationRequest.getSizeId());
        colorSizeRelation.setSize(size);


        // Business Rules
        // Validation
        ColorSizeRelation savedColorSizeRelation = colorSizeRepository.save(colorSizeRelation);

        // MAPPING -> Category => AddCategoryResponse
        AddColorSizeRelationResponse response =
                new AddColorSizeRelationResponse(savedColorSizeRelation.getId(),
                        savedColorSizeRelation.getColor().getId(),
                        savedColorSizeRelation.getSize().getId());
        return response;*/

        // MAPPING => AUTO MAPPER

        ColorSizeRelation colorSizeRelation =
                modelMapperService.getMapper().map(addColorSizeRelationRequest,ColorSizeRelation.class);
        AddColorSizeRelationResponse addColorSizeRelationResponse =
                modelMapperService.getMapper().map(colorSizeRepository.save(colorSizeRelation),AddColorSizeRelationResponse.class);
        return new SuccessDataResult<AddColorSizeRelationResponse>(addColorSizeRelationResponse,Messages.ColorSizeRelation.addColorSizeRelation);
    }



}
