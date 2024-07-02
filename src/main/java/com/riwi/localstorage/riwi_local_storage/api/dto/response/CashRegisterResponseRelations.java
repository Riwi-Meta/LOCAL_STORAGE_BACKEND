package com.riwi.localstorage.riwi_local_storage.api.dto.response;

import com.riwi.localstorage.riwi_local_storage.domain.entities.Cash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CashRegisterResponseRelations extends CashRegisterResponse{
    private Cash cash;
    //Corregir el response cuando se junte
}
