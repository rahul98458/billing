package com.model;

public class Bill {
private int id;
private int pid;
private String customername;
private String productname;
private int mrp;
private int quantity;
private String date;
private int price;
private String phone;
private int bnumber;


public int getBnumber() {
	return bnumber;
}
public void setBnumber(int bnumber) {
	this.bnumber = bnumber;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public int getMrp() {
	return mrp;
}
public void setMrp(int mrp) {
	this.mrp = mrp;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}
