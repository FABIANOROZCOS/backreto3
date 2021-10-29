package com.bike.repository;

import com.bike.model.Category;
import com.bike.repository.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository crud2;

    public List<Category> getAll() {
        return (List<Category>) crud2.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return crud2.findById(id);
    }

    public Category save(Category category) {
        return crud2.save(category);
    }
    
     public void delete(Category category) {
        crud2.delete(category);
    }
}
