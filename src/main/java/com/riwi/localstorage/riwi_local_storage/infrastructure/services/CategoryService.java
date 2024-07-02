package com.riwi.localstorage.riwi_local_storage.infrastructure.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.localstorage.riwi_local_storage.api.dto.request.create.CategoryRequest;
import com.riwi.localstorage.riwi_local_storage.api.dto.response.CategoryResponse;
import com.riwi.localstorage.riwi_local_storage.domain.entities.Category;
import com.riwi.localstorage.riwi_local_storage.domain.repositories.CategoryRepository;
import com.riwi.localstorage.riwi_local_storage.infrastructure.abstract_services.ICategoryService;
import com.riwi.localstorage.riwi_local_storage.infrastructure.mappers.CategoryMapper;
import com.riwi.localstorage.riwi_local_storage.util.exeptions.IdNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService{

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> readAll() {
        return this.categoryRepository.findAllByIsEnableTrue()
            .stream() 
            .map(categoryMapper::categoryToCategoryResponse) 
            .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse create(CategoryRequest request) {
        Category category = categoryMapper.categoryRequestToCategory(request);
        return categoryMapper.categoryToCategoryResponse(this.categoryRepository.save(category));
    }

    @Override
    public CategoryResponse update(String id, CategoryRequest request) {
        Category category = find(id);
        categoryMapper.categoryToUpdate(request, category);
        return categoryMapper.categoryToCategoryResponse(this.categoryRepository.save(category));
    }

    @Override
    public void delete(String id) {
        // search if is enable ande then change the is enabled attribute
        Category category = this.find(id);
        if (category != null){
            category.setEnable(false);
            this.categoryRepository.save(category);
        }
    }

    public Category find(String id) {
        return categoryRepository.findByIdAndIsEnableTrue(id).orElseThrow(() -> new IdNotFoundException("Category", Long.valueOf(id)));
    }
}
