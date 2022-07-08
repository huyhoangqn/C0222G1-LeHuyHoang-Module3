package model.service.category;

import model.bean.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(int id);
}
