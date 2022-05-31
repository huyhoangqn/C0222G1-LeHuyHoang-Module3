package repository;

import model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getListStudent();

    void save(Product product);

    Product findById(Integer id);

    void deleteById(Integer id);

    int position();
}
