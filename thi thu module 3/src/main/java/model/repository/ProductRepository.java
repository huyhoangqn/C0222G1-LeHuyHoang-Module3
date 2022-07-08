package model.repository;

import model.bean.Category;
import model.bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final String GET_ALL = "select * from product left join category c on product.category_id = c.id;";
    private static final String INSERT_INTO_PRODUCT = "insert into product(name, price, quantity, color, description, category_id) " +
            " VALUES (?,?,?,?,?,?);";
    private static final String FIND_BY_ID = "select * from product left join category c on product.category_id = c.id" +
            " where product.id=?";

    private static final String UPDATE = "update product set name=?,price=?,quantity=?,color=?,description=?,category_id=? " +
            " where product.id=?;";
    private static final String DELETE = "DELETE FROM product WHERE id=?;";
    private static String SEARCH = "select * from product left join category c on product.category_id = c.id\n" +
            " where product.name like ? and product.color like ? and c.id like ?;";


    DatabaseRepository databaseRepository = new DatabaseRepository();
    Connection connection;

    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        connection = databaseRepository.connectDataBase();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
        ResultSet resultSet = preparedStatement.executeQuery(); // resultSet đại diện cho bảng product
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            int quantity = resultSet.getInt("quantity");
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");

            int categoryId = resultSet.getInt("category_id");
            String categoryName = resultSet.getString("c.name");  //Vì câu query GET_ALL đã kết nối được với bảng nên dùng c đại diện cho category
            // Vì category là bảng con của product nên khi xét trên cùng 1 hàng sẽ tự get name từ bảng category.
            Category category = new Category(categoryId, categoryName);
            Product product = new Product(id, name, price, quantity, color, description, category); // Sử dụng constructor 1
            products.add(product);
        }
        return products;
    }

    public List<Product> search(String name, String colors, String idCategory) {
        connection = databaseRepository.connectDataBase();
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + colors + "%");
            preparedStatement.setString(3, "%" + idCategory + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("product.id");
                String name1 = resultSet.getString("product.name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int categoryId = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("c.name");
                Category category = new Category(categoryId, categoryName);
                Product product = new Product(id, name1, price, quantity, color, description, category);
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public void delete(int id) {
        connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Product findById(int id) throws SQLException {
        connection = databaseRepository.connectDataBase();
        Product product = null;

        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id1 = resultSet.getInt("id");
            String name = resultSet.getString("product.name");
            double price = resultSet.getDouble("price");
            int quantity = resultSet.getInt("quantity");
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            int categoryId = resultSet.getInt("category_id");
            String categoryName = resultSet.getString("c.name");
            Category category = new Category(categoryId, categoryName);
            product = new Product(id1, name, price, quantity, color, description, category);
        }

        return product;
    }

    public void update(Product product, int categoryId) throws SQLException {
        connection = databaseRepository.connectDataBase();

        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setString(5, product.getDescription());
        preparedStatement.setInt(6, categoryId);
        preparedStatement.setInt(7, product.getId());
        preparedStatement.executeUpdate();

    }


//    public void insertProduct(Product product) throws SQLException {
//        connection = databaseRepository.connectDataBase();
//        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_STUDENT);
//        preparedStatement.setString(1, product.getName());
//        preparedStatement.setDouble(2, product.getPrice());
//        preparedStatement.setInt(3, product.getQuantity());
//        preparedStatement.setString(4, product.getColor());
//        preparedStatement.setString(5, product.getDescription());
//        preparedStatement.setInt(6, product.getCategory().getId());
//        preparedStatement.executeUpdate();
//    }

    public void insertProduct(Product product, int categoryId) {
        connection = databaseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, categoryId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
