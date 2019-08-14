package model;
 
import java.util.Date;
 
public class Product {

	private int productId;
	private String productName;
	private String description;
	
	private String price;
	private String storeId;
	private String quantity;
	private String categoryId;
	private String picture;
	private String pStoreName;
	private String pCatName;
	 


	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productid) {
		this.productId = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	 
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	 
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
	}
	public String getpStoreName() {
		return pStoreName;
	}
	public void setpStoreName(String pStoreName) {
		this.pStoreName = pStoreName;
	}
	public String getpCatName() {
		return pCatName;
	}
	public void setpCatName(String pCatName) {
		this.pCatName = pCatName;
	}
}