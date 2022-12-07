package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.ColorService;
import com.etiya.ecommercedemo5.business.abstracts.ColorSizeRelationService;
import com.etiya.ecommercedemo5.business.abstracts.SizeService;
import com.etiya.ecommercedemo5.business.dtos.request.colorsizerelation.AddColorSizeRelationRequest;
import com.etiya.ecommercedemo5.business.dtos.response.colorsizerelation.AddColorSizeRelationResponse;
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
    private SizeService sizeService;
    private ColorService colorService;
    @Override
    public List<ColorSizeRelation> getAll() {
        return colorSizeRepository.findAll();
    }

    @Override
    public ColorSizeRelation getById(int id) {
        return colorSizeRepository.findById(id).orElseThrow();
    }

    @Override
    public AddColorSizeRelationResponse addColorSizeRelation(AddColorSizeRelationRequest addColorSizeRelationRequest) {
        // MAPPING => AUTO MAPPER
        ColorSizeRelation colorSizeRelation = new ColorSizeRelation();

        Color color = colorService.getById(addColorSizeRelationRequest.getColorid());
        colorSizeRelation.setColor(color);

        Size size = sizeService.getById(addColorSizeRelationRequest.getSizeid());
        colorSizeRelation.setSize(size);


        // Business Rules
        // Validation
        ColorSizeRelation savedColorSizeRelation = colorSizeRepository.save(colorSizeRelation);

        // MAPPING -> Category => AddCategoryResponse
        AddColorSizeRelationResponse response =
                new AddColorSizeRelationResponse(savedColorSizeRelation.getId(),
                        savedColorSizeRelation.getColor().getId(),
                        savedColorSizeRelation.getSize().getId());
        return response;
    }



}
