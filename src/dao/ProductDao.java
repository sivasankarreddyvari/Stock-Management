package dao;
 
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.Store;
import util.DbUtil;

public class ProductDao {
	
	private Connection connection;
	
	public ProductDao() {
		connection = DbUtil.getConnection();
	}
	
	public void addProduct(Product product) {
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("insert into products (store_id, category_id, product_name, description, picture, quantity, price) values (?, ?, ?, ?, ?, ?, ? )");
			preparedStatement.setString(1, product.getStoreId());
			preparedStatement.setString(2, product.getCategoryId());
			preparedStatement.setString(3, product.getProductName());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setString(5, product.getPicture());
			preparedStatement.setString(6, product.getQuantity());
			preparedStatement.setString(7, product.getPrice());
			preparedStatement.executeUpdate();
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProduct(int productId) {
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("delete from products where product_id=?");
			preparedStatement.setInt(1, productId);
			preparedStatement.executeUpdate();
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateProduct(Product product) {
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("update products set category_id=?, product_name=?, description=?, picture=?, quantity=?, price=?" +
			"where product_id=?");
			// Parameters start with 1
			//preparedStatement.setString(1, product.getStoreId());
			preparedStatement.setString(1, product.getCategoryId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setString(4, product.getPicture());
			preparedStatement.setString(5, product.getQuantity());
			preparedStatement.setString(6, product.getPrice());
			preparedStatement.setInt(7, product.getProductId());
			preparedStatement.executeUpdate();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from products p "
					+ "join stores s on (s.store_id = p.store_id) "
					+ "join categories c on (c.category_id = p.category_id) "
					+ "order by product_id desc");
			//ResultSet rs = statement.executeQuery("select * from products order by product_id desc");
			while (rs.next()) {
				Product product = new Product();
				//Store store = new Store();
				product.setProductId(rs.getInt("p.product_id"));
				product.setProductName(rs.getString("p.product_name"));
				product.setDescription(rs.getString("p.description"));
				product.setPrice(rs.getString("p.price"));
				product.setStoreId(rs.getString("p.store_id"));
				product.setCategoryId(rs.getString("p.category_id"));
				product.setQuantity(rs.getString("p.quantity"));
				
				product.setpStoreName(rs.getString("s.store_name"));
				product.setpCatName(rs.getString("c.category_name"));
				
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public List<Product> getSearchProducts( String productName) {

		List<Product> products = new ArrayList<Product>();
		try {
			
			ResultSet rs = null;
			if ( productName != null) {
				
				PreparedStatement preparedStatement = connection.
						  prepareStatement("select * from products p join stores s on (s.store_id = p.store_id) join categories c on (c.category_id = p.category_id) "
						  		+ "where p.product_name = ?"); 
				preparedStatement.setString(1, productName); 
				rs = preparedStatement.executeQuery();
			} 
			
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("p.product_id"));
				product.setProductName(rs.getString("p.product_name"));
				product.setDescription(rs.getString("p.description"));
				product.setPrice(rs.getString("p.price"));
				product.setStoreId(rs.getString("p.store_id"));
				product.setCategoryId(rs.getString("p.category_id"));
				product.setQuantity(rs.getString("p.quantity"));
				product.setpStoreName(rs.getString("s.store_name"));
				product.setpCatName(rs.getString("c.category_name"));
				
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}
	public Product getProductById(int productId) {
		Product product = new Product();
		try {
			PreparedStatement preparedStatement = connection.
			prepareStatement("select * from products where product_id=?");
			preparedStatement.setInt(1, productId);
			ResultSet rs = preparedStatement.executeQuery();
			 
			if (rs.next()) {
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getString("price"));
				product.setStoreId(rs.getString("store_id"));
				product.setCategoryId(rs.getString("category_id"));
				product.setQuantity(rs.getString("quantity"));
				product.setPicture(rs.getString("picture"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}
	
	public List<Product> listProducts() {
		List<Product> productsList = new ArrayList<Product>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from products ORDER BY product_name");
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				productsList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productsList;
	}
	
	
}