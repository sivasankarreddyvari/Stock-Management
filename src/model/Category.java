package model;
 
import java.util.Date;
 
public class Category {
 
private int categoryId;
private String categoryName;
private String description;
 


 public int getCategoryId() {
	 return categoryId;
 }
 public void setCategoryId(int categoryId) {
 this.categoryId = categoryId;
 }
 public String getCategoryName() {
	 return categoryName;
 }
 public void setCategoryName(String categoryName) {
	 this.categoryName = categoryName;
 }

 public String getDescription() {
	 return description;
 }
 public void setDescription(String description) {
	 this.description = description;
 }
  
 @Override
 public String toString() {
 return "Cateogry [categoryId=" + categoryId + ", categoryName=" + categoryName
 + ", descriptioni=" + description + "]";
 }
}