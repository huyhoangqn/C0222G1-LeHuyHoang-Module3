package service.impl;

import model.Product;
import repository.IProductRepo;
import repository.impl.ProductRepo;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {

    IProductRepo productRepo = new ProductRepo();

    public List<Product> getListStudent() {
        return productRepo.getListStudent();
    } //Mục đích: Lấy list gửi lên trang jsp để hiển thị lên màn hình

    public void save(Product product) {
        productRepo.save(product);
    }

    public Product findById(Integer id) {
        return productRepo.findById(id);
    }

    public void deleteById(Integer id) {
        productRepo.deleteById(id);
    }

    public int position() {
        return productRepo.position();
    }
}
