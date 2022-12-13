package com.etiya.ecommercedemo5.business.dtos.request.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddAddressRequest {
    private int addrestitleId;
    private String street;
    private int cityId;
    private int customerId;
}
