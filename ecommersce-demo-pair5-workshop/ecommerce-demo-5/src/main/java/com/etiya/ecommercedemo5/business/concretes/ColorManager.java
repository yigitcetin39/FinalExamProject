package com.etiya.ecommercedemo5.business.concretes;

import com.etiya.ecommercedemo5.business.abstracts.ColorService;
import com.etiya.ecommercedemo5.business.dtos.request.color.AddColorRequest;
import com.etiya.ecommercedemo5.business.dtos.response.color.AddColorResponse;
import com.etiya.ecommercedemo5.entities.concretes.Color;
import com.etiya.ecommercedemo5.repository.abstracts.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {

    private ColorRepository colorRepository;

    @Override
    public List<Color> getAll() {
        // SAYFALAMA
        // FİLTRELEME
        return colorRepository.findAll();
    }

    @Override
    public Color getById(int id) {
        return colorRepository.findById(id).orElseThrow();
    }

    // JPA Repository SAVE methodu, eklenen veriyi geri döner.
    @Override
    public AddColorResponse addColor(AddColorRequest addColorRequest) {
        // MAPPING => AUTO MAPPER
        Color color = new Color();
        color.setName(addColorRequest.getName());

        //
        // Business Rules
        // Validation
        Color savedColor = colorRepository.save(color);

        // MAPPING -> Category => AddCategoryResponse
        AddColorResponse response =
                new AddColorResponse(savedColor.getId(), savedColor.getName());
        //
        return response;
    }
}
