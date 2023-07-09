package com.model;

public class Sale {
private int id;
private String date;
private String cname;
private String phone;
private int total;
private int billnum;

public int getBillnum() {
	return billnum;
}
public void setBillnum(int billnum) {
	this.billnum = billnum;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}

}
