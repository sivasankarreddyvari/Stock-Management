package model;
 
import java.util.Date;
 
public class Store {
 
private int storeId;
private String storeName;
private String address1;

private String address2;
private String city;
private String state;
private String zipCode;
private String phoneNumber;
private String description; 
//private String description;
 
 public int getStoreId() {
 return storeId;
 }
 public void setStoreId(int storeid) {
 this.storeId = storeid;
 }
 public String getStoreName() {
 return storeName;
 }
 public void setStoreName(String storeName) {
 this.storeName = storeName;
 }
 public String getAddress1() {
 return address1;
 }
 public void setAddress1(String address1) {
 this.address1 = address1;
 }
 
 public String getAddress2() {
	 return address2;
 }
 public void setAddress2(String address2) {
	 this.address2 = address2;
 }


 public String getCity() {
	 return city;
 }
 public void setCity(String city) {
	 this.city = city;
 }


 public String getState() {
	 return state;
 }
 public void setState(String state) {
	 this.state = state;
 }
 

 public String getZipCode() {
	 return zipCode;
 }
 public void setZipCode(String zipCode) {
	 this.zipCode = zipCode;
 }
 
 public String getPhoneNumber() {
	 return phoneNumber;
 }
 public void setPhoneNumber(String phoneNumber) {
	 this.phoneNumber = phoneNumber;
 }

 public String getDescription() {
	 return description;
 }
 public void setDescription(String description) {
	 this.description = description;
 }
 
/* public String getDescription() {
	 return description;
 }
 public void setDescription(String description) {
	 this.description = description;
 }*/
 
 @Override
 public String toString() {
 return "Store [storeId=" + storeId + ", storeName=" + storeName
 + ", address=" + address1 + "]";
 }
}