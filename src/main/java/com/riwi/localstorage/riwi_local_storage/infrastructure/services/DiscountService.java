package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.DiscountRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.DiscountResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Discount;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.DiscountRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.IDiscountService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.DiscountMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.IdNotFoundException;

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
  public DiscountResponse update(String id, DiscountRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public Page<DiscountResponse> findAllByIsActive(boolean isActive, Pageable pageable) {
    return this.discountRepository.findAllByIsActive(isActive, pageable)
        .map(this.discountMapper::discountToDiscountResponse);

  }

}
