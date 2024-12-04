package com.example.lab11.Repository;

import com.example.lab11.Model.Category;
import com.example.lab11.Model.User;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findCategoriesByCategoryId(Integer id);

}
