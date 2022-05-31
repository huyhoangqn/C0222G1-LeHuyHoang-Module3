package repository.impl;

import model.Product;
import repository.IProductRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo implements IProductRepo {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "Coca", "2000", "Ok", "samsung"));
        productMap.put(2, new Product(2, "PepSi", "3000", "tam", "nokia"));
        productMap.put(3, new Product(3, "beer", "10000", "ngon", "Saigon"));
    }
    public  List<Product> getListStudent() {
        return new ArrayList<>(productMap.values());
    } //Mục đích: Lấy list gửi lên trang jsp để hiển thị lên màn hình

    public  void save(Product product) {
        productMap.put(product.getId(), product);
    }

    public  Product findById(Integer id) {
        return productMap.get(id);
    }

    public  void deleteById(Integer id) {
        productMap.remove(id);
    }

    public  int position() {
        return productMap.get(productMap.size()).getId() + 1;
    }
}
