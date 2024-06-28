package com.riwi.localstorage.riwi_local_storage.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CategoryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CategoryResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target="id", ignore=true)
    @Mapping(target="products", ignore=true)
    Category categoryRequestToCategory(CategoryRequest category);
    
    CategoryResponse categoryToCategoryResponse(Category category);
    
    @Mapping(target="id", ignore=true)
    @Mapping(target="products", ignore=true)
    void categoryToUpdate(CategoryRequest category, @MappingTarget Category target);
}
