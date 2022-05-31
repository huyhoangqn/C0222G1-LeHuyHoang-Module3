package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getListStudent();

    void save(Product product);

    Product findById(Integer id);

    void deleteById(Integer id);

    int position();
}
