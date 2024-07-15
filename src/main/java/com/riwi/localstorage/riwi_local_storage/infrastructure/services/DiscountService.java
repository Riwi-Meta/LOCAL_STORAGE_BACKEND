package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.DiscountRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.request.update.DiscountRequestUpdate;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.DiscountResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Discount;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.DiscountRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IDiscountService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.DiscountMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.IdNotFoundException;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.InvalidDataException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DiscountService implements IDiscountService {

  @Autowired
  private final DiscountRepository discountRepository;

  @Autowired
  private final DiscountMapper discountMapper;

  @Override
  public DiscountResponse create(DiscountRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public void updateDiscountStatus(String id, boolean isActive) {
    Discount discount = findDiscount(id);
    discount.setIsActive(isActive);

    this.discountRepository.save(discount);
  }

  @Override
  public Page<DiscountResponse> getAll(Pageable pageable) {
    return this.discountRepository.findAll(pageable).map(this.discountMapper::discountToDiscountResponse);
  }

  @Override
  public Optional<DiscountResponse> getById(String id) {
    Discount discount = findDiscount(id);

    return Optional.ofNullable(this.discountMapper.discountToDiscountResponse(discount));
  }

  @Override
  public Discount findDiscount(String id) {
    return discountRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Discount ", id));
  }

  @Override
  public DiscountResponse update(String id, DiscountRequestUpdate request) {
    Discount discount = findDiscount(id);
    validateDiscountRequest(request);

    discount.setType(request.getType());
    discount.setAmount(request.getAmount());
    discount.setStartDate(request.getStartDate());
    discount.setEndDate(request.getEndDate());
    discount.setIsActive(request.getIsActive());
    discount.setCode(request.getCode());

    Discount updatedDiscount = discountRepository.save(discount);
    return discountMapper.discountToDiscountResponse(updatedDiscount);
  }

  private void validateDiscountRequest(DiscountRequestUpdate request) {
    if (request.getAmount() <= 0) {
      throw new InvalidDataException("Amount must be greater than 0");
    }
    if (request.getStartDate().isAfter(request.getEndDate())) {
      throw new InvalidDataException("Start date must be before end date");
    }
    if (discountRepository.existsByCodeAndIdNot(request.getCode(), request.getId())) {
      throw new InvalidDataException("Discount code already exists");
    }
  }

  @Override
  public Page<DiscountResponse> findAllByIsActive(boolean isActive, Pageable pageable) {
    return this.discountRepository.findAllByIsActive(isActive, pageable)
        .map(this.discountMapper::discountToDiscountResponse);

  }

}
