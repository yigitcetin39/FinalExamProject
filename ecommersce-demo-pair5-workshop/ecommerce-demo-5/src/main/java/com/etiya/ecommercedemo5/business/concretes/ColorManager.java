package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.ColorService;
import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.business.dtos.request.color.AddColorRequest;
import com.etiya.ecommercedemo5.business.dtos.response.color.AddColorResponse;
import com.etiya.ecommercedemo5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo5.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo5.entities.concretes.Color;
import com.etiya.ecommercedemo5.repository.abstracts.ColorRepository;
import lombok.AllArgsConstructor;
import org.aspectj.apache.bcel.generic.MethodGen;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    private ColorRepository colorRepository;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;

    @Override
    public DataResult<List<Color>> getAll() {
        List<Color> response = this.colorRepository.findAll();
        // SAYFALAMA
        // FİLTRELEME
        return new SuccessDataResult<List<Color>>(response, messageSource.getMessage(Messages.Color.getAllColor,null,LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<Color> getById(int id) {
        Color response = this.colorRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Color>(response, messageSource.getMessage(Messages.Color.getByColorId,null,LocaleContextHolder.getLocale()));
    }

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
    @Override
    public DataResult<AddColorResponse> addColor(AddColorRequest addColorRequest) {

        colorCanNotExistWithSameName(addColorRequest.getName());
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
        return new SuccessDataResult<AddColorResponse>(addColorResponse,messageSource.getMessage(Messages.Color.addColor,null,LocaleContextHolder.getLocale()));
    }

    private void colorCanNotExistWithSameName(String name){
        boolean isExists = colorRepository.existsColorByName(name);
        if(isExists) // Veritabanımda bu isimde bir renk mevcut!!
            throw new BusinessException(messageSource.getMessage(Messages.Color.ColorExistsWithSameName,null,
                    LocaleContextHolder.getLocale()));
    }
}
