package com.example.lab11.Service;

import com.example.lab11.ApiResponse.ApiException;
import com.example.lab11.Model.Category;
import com.example.lab11.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id,Category category){
        Category oldCategory = categoryRepository.findCategoriesByCategoryId(id);
        if(oldCategory == null){
            throw new ApiException("id not found");
        }
        oldCategory.setUsername(category.getUsername());
        categoryRepository.save(oldCategory);
    }

    public void deleteCategory(Integer id){
        Category delCategory = categoryRepository.findCategoriesByCategoryId(id);
        if(delCategory == null){
            throw new ApiException("id not found");
        }
        categoryRepository.delete(delCategory);
    }
}
