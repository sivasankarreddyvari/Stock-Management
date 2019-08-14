package dao;
 
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Store;
import util.DbUtil;

public class CategoryDao {

	private Connection connection;
	
	public CategoryDao() {
		connection = DbUtil.getConnection();
	}
	
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from categories order by category_id desc");
			while (rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				category.setDescription(rs.getString("description"));
				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 
		return categories;
	}
	
	public Category getCategoryById(int categoryId) {
		Category category = new Category();
		try {
			PreparedStatement preparedStatement = connection.
			prepareStatement("select * from categories where category_id=?");
			preparedStatement.setInt(1, categoryId);
			ResultSet rs = preparedStatement.executeQuery();
			 
			if (rs.next()) {
				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				category.setDescription(rs.getString("description"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		return category;
	}
	
	public void addCategory(Category category) {
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("insert into categories(category_name, description) values (?, ? )");
			preparedStatement.setString(1, category.getCategoryName());
			preparedStatement.setString(2, category.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCategory(int categoryId) {
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("delete from categories where category_id=?");
			preparedStatement.setInt(1, categoryId);
			preparedStatement.executeUpdate();
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
	public void updateCategory(Category category) {
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("update categories set category_name=?, description=?" +
			"where category_id=?");
			// Parameters start with 1
			preparedStatement.setString(1, category.getCategoryName());
			preparedStatement.setString(2, category.getDescription());
			preparedStatement.setInt(3, category.getCategoryId());
			preparedStatement.executeUpdate();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Category> listCategories(){
        List<Category> listCategories = new ArrayList<Category>();
         
        try {
            Statement statement = connection.createStatement();
    		ResultSet rs = statement.executeQuery("SELECT * FROM categories ORDER BY category_name");
             
            while (rs.next()) {
            	Category category = new Category();
            	category.setCategoryId(rs.getInt("category_id"));
    			category.setCategoryName(rs.getString("category_name"));
                listCategories.add(category);
            }           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }       
         
        return listCategories;
    }
}
