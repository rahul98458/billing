package com.service;

import java.util.List;

import com.model.Bill;
import com.model.Product;

public interface BillService {
 void addBill(Bill b);
   List<Bill> displayBillByName(String name,String date,String phone);
	boolean deleteProduct(int id);
	 List<Bill> displayAllBill();
	 List<Bill> searchBillByName(String name);
	 List<Bill> searchBillByDate(String date);
	 List<Bill> searchBillByPhone(String phone);
	 List<Bill> displayById(String name,String date,String phone,int bn);
	 List<Bill> searchBillByBillNum(int bnum);
	 List<Bill> searchBillLikeBillNum(String bnum);
}
