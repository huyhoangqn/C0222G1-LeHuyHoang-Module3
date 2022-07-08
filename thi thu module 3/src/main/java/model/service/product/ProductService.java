package model.service.product;

import model.bean.Category;
import model.bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> findAll() throws SQLException;

//    void create(Product student) throws SQLException;

    List<String> create(Product product, int categoryId);

    List<String> update(Product student, int categoryId);

    Product findById(int id) throws SQLException;

    void delete(int id);
    List<Product> search(String name, String color, String idCategory);
    List<Category> findAllCategory();
}
