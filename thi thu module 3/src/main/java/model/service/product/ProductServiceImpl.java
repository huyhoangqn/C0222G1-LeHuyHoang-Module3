package model.service.product;

import model.bean.Category;
import model.bean.Product;
import model.repository.CategoryRepository;
import model.repository.ProductRepository;
import model.service.validator.ProductValidator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository studentRepository = new ProductRepository();
    ProductValidator studentValidator = new ProductValidator();
    CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    public List<Product> findAll() throws SQLException {
        return studentRepository.findAll();
    }

//    @Override
//    public void create(Product student) throws SQLException {
//        studentRepository.insertProduct(student);
//    }

    @Override
    public List<String> create(Product product, int categoryId) {
        List<String> errors = new ArrayList<>();
        try {
            studentRepository.insertProduct(product, categoryId);
            errors.add("add success");
        } catch (Exception e) {
            errors.add("add fail");
        }
        return errors;
    }

    @Override
    public List<String> update(Product student, int classId) {

        List<String> errors = new ArrayList<>();
        try {
            studentRepository.update(student, classId);
            errors.add("update success");
        } catch (Exception e) {
            errors.add("update fail");
        }
        return errors;
    }

    @Override
    public Product findById(int id) throws SQLException {
        return studentRepository.findById(id);

    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }

    @Override
    public List<Product> search(String name, String color, String idCategory) {
        return studentRepository.search(name, color, idCategory);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
