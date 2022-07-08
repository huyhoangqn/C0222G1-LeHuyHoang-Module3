package model.service.category;

import model.bean.Category;
import model.repository.CategoryRepository;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    CategoryRepository classRepository = new CategoryRepository();

    @Override
    public List<Category> findAll() {
        return classRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return classRepository.findById(id);
    }
}
