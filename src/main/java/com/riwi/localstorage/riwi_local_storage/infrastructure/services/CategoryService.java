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
        return this.categoryRepository.findAll()
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
        //We will just modify the isEname attribute.
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public Category find(String Id){
        return this.categoryRepository.findById(Id).orElseThrow(() -> new RuntimeException("No such category"));
    }
}
