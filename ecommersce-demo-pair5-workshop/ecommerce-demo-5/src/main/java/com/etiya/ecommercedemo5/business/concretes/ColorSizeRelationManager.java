package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.ColorService;
import com.etiya.ecommercedemo5.business.abstracts.ColorSizeRelationService;
import com.etiya.ecommercedemo5.business.abstracts.SizeService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.colorsizerelation.AddColorSizeRelationRequest;
import com.etiya.ecommercedemo5.business.dtos.response.colorsizerelation.AddColorSizeRelationResponse;
import com.etiya.ecommercedemo5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Color;
import com.etiya.ecommercedemo5.entities.concretes.ColorSizeRelation;
import com.etiya.ecommercedemo5.entities.concretes.Size;
import com.etiya.ecommercedemo5.repository.abstracts.ColorRepository;
import com.etiya.ecommercedemo5.repository.abstracts.ColorSizeRepository;
import com.etiya.ecommercedemo5.repository.abstracts.SizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorSizeRelationManager implements ColorSizeRelationService {

    private ColorSizeRepository colorSizeRepository;
    private ModelMapperService modelMapperService;
    private ColorRepository colorRepository;
    private SizeRepository sizeRepository;
    private MessageSource messageSource;
    private ColorService colorService;
    @Override
    public DataResult<List<ColorSizeRelation>> getAll() {
        List<ColorSizeRelation> response = this.colorSizeRepository.findAll();
        return new SuccessDataResult<List<ColorSizeRelation>>(response, messageSource.getMessage(Messages.ColorSizeRelation.getAllColorSizeRelation,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<ColorSizeRelation> getById(int id) {
        ColorSizeRelation response = this.colorSizeRepository.findById(id).orElseThrow();
        return new SuccessDataResult<ColorSizeRelation>(response,messageSource.getMessage(Messages.ColorSizeRelation.getByColorSizeRelationId,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<AddColorSizeRelationResponse> addColorSizeRelation(AddColorSizeRelationRequest addColorSizeRelationRequest) {

        checkIfExistsSizeId(addColorSizeRelationRequest.getSizeId());
        checkIfExistsColorId(addColorSizeRelationRequest.getColorId());
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
        return new SuccessDataResult<AddColorSizeRelationResponse>(addColorSizeRelationResponse,messageSource.getMessage(Messages.ColorSizeRelation.addColorSizeRelation,null,LocaleContextHolder.getLocale()));
    }

    public void checkIfExistsColorId(int id){
        boolean isExists = colorRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(messageSource.getMessage(Messages.Color.runTimeException,null, LocaleContextHolder.getLocale()));
        }
    }

    public void checkIfExistsSizeId(int id){
        boolean isExists = sizeRepository.existsById(id);
        if (!isExists){
            throw new BusinessException(messageSource.getMessage(Messages.Size.runTimeException,null, LocaleContextHolder.getLocale()));
        }
    }



}
