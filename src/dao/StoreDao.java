package dao;
 
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import com.*;
import model.Store;
//import com.daniel.util.DbUtil;
import util.DbUtil;
 
public class StoreDao {
 
	private Connection connection;
 
	public StoreDao() {
		connection = DbUtil.getConnection();
	}
 
	public void addStore(Store store) {
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("insert into stores(store_name, description, address1, address2, city,  state, zip_code, phone_number) values (?, ?, ?, ?, ?, ?, ?, ? )");
			preparedStatement.setString(1, store.getStoreName());
			preparedStatement.setString(2, store.getDescription());
			preparedStatement.setString(3, store.getAddress1());
			preparedStatement.setString(4, store.getAddress2());
			preparedStatement.setString(5, store.getCity());
			preparedStatement.setString(6, store.getState());
			preparedStatement.setString(7, store.getZipCode());
			preparedStatement.setString(8, store.getPhoneNumber());
			preparedStatement.executeUpdate();
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
	public void deleteStore(int storeId) {
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("delete from stores where store_id=?");
			preparedStatement.setInt(1, storeId);
			preparedStatement.executeUpdate();
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
	public void updateStore(Store store) {
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("update stores set store_name=?, description=?, address1=?, address2=?, city=?, state=?, zip_code=?, phone_number=?" +
			"where store_id=?");
			// Parameters start with 1
			preparedStatement.setString(1, store.getStoreName());
			preparedStatement.setString(2, store.getDescription());
			preparedStatement.setString(3, store.getAddress1());
			preparedStatement.setString(4, store.getAddress2());
			preparedStatement.setString(5, store.getCity());
			preparedStatement.setString(6, store.getState());
			preparedStatement.setString(7, store.getZipCode());
			preparedStatement.setString(8, store.getPhoneNumber());
			preparedStatement.setInt(9, store.getStoreId());
			preparedStatement.executeUpdate();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
	public List<Store> listStores() {
		List<Store> storesList = new ArrayList<Store>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from stores ORDER BY store_name");
			while(rs.next()) {
				Store store = new Store();
				store.setStoreId(rs.getInt("store_id"));
				store.setStoreName(rs.getString("store_name"));
				storesList.add(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return storesList;
	}
	
	public List<Store> getAllStores() {
		List<Store> stores = new ArrayList<Store>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from stores order by store_id desc");
			while (rs.next()) {
				Store store = new Store();
				store.setStoreId(rs.getInt("store_id"));
				store.setStoreName(rs.getString("store_name"));
				store.setDescription(rs.getString("description"));
				store.setAddress1(rs.getString("address1"));
				store.setAddress2(rs.getString("address2"));
				store.setPhoneNumber(rs.getString("phone_number"));
				store.setCity(rs.getString("city"));
				store.setState(rs.getString("state"));
				store.setZipCode(rs.getString("zip_code"));
				stores.add(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 
		return stores;
	}
 
	public Store getStoreById(int storeId) {
		Store store = new Store();
		try {
			PreparedStatement preparedStatement = connection.
			prepareStatement("select * from stores where store_id=?");
			preparedStatement.setInt(1, storeId);
			ResultSet rs = preparedStatement.executeQuery();
			 
			if (rs.next()) {
				store.setStoreId(rs.getInt("store_id"));
				store.setStoreName(rs.getString("store_name"));
				store.setDescription(rs.getString("description"));
				store.setAddress1(rs.getString("address1"));
				store.setAddress2(rs.getString("address2"));
				store.setCity(rs.getString("city"));
				store.setState(rs.getString("state"));
				store.setZipCode(rs.getString("zip_code"));
				store.setPhoneNumber(rs.getString("phone_number"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		return store;
	}
}


