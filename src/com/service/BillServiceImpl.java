package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.Db;
import com.model.Bill;
import com.model.Cashier;
import com.model.Product;

public class BillServiceImpl implements BillService{

	@Override
	public void addBill(Bill b) {
		String sql = "insert into bill(bill_number,customer_name,product_id,product_name,mrp,quantity,date,price,phone)values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = Db.getDbConnection().prepareStatement(sql);
			pstm.setInt(1,b.getBnumber());
			pstm.setString(2,b.getCustomername());
			pstm.setInt(3,b.getPid());
			pstm.setString(4,b.getProductname());
			pstm.setInt(5,b.getMrp());
			pstm.setInt(6,b.getQuantity());
			pstm.setString(7,b.getDate());
			pstm.setInt(8,b.getPrice());
			pstm.setString(9,b.getPhone());
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Bill> displayBillByName(String name,String date,String phone) {
		String sql = "select * from bill where customer_name='"+name+"'and date ='"+date+"' and phone='"+phone+"'";
		List<Bill> blist = new ArrayList<>();
		try {
			Statement smt = Db.getDbConnection().createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next())
			{
				Bill b = new Bill();
				b.setId(Integer.parseInt(rs.getString("id")));
				b.setCustomername(rs.getString("customer_name"));
				b.setDate(rs.getString("date"));
				b.setPid(Integer.parseInt(rs.getString("product_id")));
				b.setMrp(Integer.parseInt(rs.getString("mrp")));
				b.setQuantity(Integer.parseInt(rs.getString("quantity")));
				b.setProductname(rs.getString("product_name"));
				b.setPrice(Integer.parseInt(rs.getString("price")));
			
				blist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
	}

	@Override
	public boolean deleteProduct(int id) {
		String sql = "delete  from bill where id = '"+id+"'";
		try {
			Statement stm = Db.getDbConnection().createStatement();
			int res=stm.executeUpdate(sql);
			if(res!=0)
			{
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Bill> displayAllBill() {
		String sql = "select * from bill ";
		List<Bill> blist = new ArrayList<>();
		try {
			Statement smt = Db.getDbConnection().createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next())
			{
				Bill b = new Bill();
				b.setId(Integer.parseInt(rs.getString("id")));
				b.setCustomername(rs.getString("customer_name"));
				b.setDate(rs.getString("date"));
				b.setPid(Integer.parseInt(rs.getString("product_id")));
				b.setMrp(Integer.parseInt(rs.getString("mrp")));
				b.setQuantity(Integer.parseInt(rs.getString("quantity")));
				b.setProductname(rs.getString("product_name"));
				b.setPrice(Integer.parseInt(rs.getString("price")));
				b.setPhone(rs.getString("phone"));
				b.setBnumber(Integer.parseInt(rs.getString("bill_number")));
				blist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
	}

	@Override
	public List<Bill> searchBillByName(String name) {
		String sql = "select * from bill where customer_name like '%"+name+"%'";
		List<Bill> blist = new ArrayList<>();
		try {
			Statement smt = Db.getDbConnection().createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next())
			{
				Bill b = new Bill();
				b.setId(Integer.parseInt(rs.getString("id")));
				b.setCustomername(rs.getString("customer_name"));
				b.setDate(rs.getString("date"));
				b.setPid(Integer.parseInt(rs.getString("product_id")));
				b.setMrp(Integer.parseInt(rs.getString("mrp")));
				b.setQuantity(Integer.parseInt(rs.getString("quantity")));
				b.setProductname(rs.getString("product_name"));
				b.setPrice(Integer.parseInt(rs.getString("price")));
				 b.setBnumber(Integer.parseInt(rs.getString("bill_number")));
			    b.setPhone(rs.getString("phone"));
				blist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
	}

	@Override
	public List<Bill> searchBillByDate(String date) {
		String sql = "select * from bill where date like '%"+date+"%'";
		List<Bill> blist = new ArrayList<>();
		try {
			Statement smt = Db.getDbConnection().createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next())
			{
				Bill b = new Bill();
				b.setId(Integer.parseInt(rs.getString("id")));
				b.setCustomername(rs.getString("customer_name"));
				b.setDate(rs.getString("date"));
				b.setPid(Integer.parseInt(rs.getString("product_id")));
				b.setMrp(Integer.parseInt(rs.getString("mrp")));
				b.setQuantity(Integer.parseInt(rs.getString("quantity")));
				b.setProductname(rs.getString("product_name"));
				b.setPrice(Integer.parseInt(rs.getString("price")));
				 b.setBnumber(Integer.parseInt(rs.getString("bill_number")));
			    b.setPhone(rs.getString("phone"));
				blist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
	}

	@Override
	public List<Bill> searchBillByPhone(String phone) {
		
		String sql = "select * from bill where phone like '%"+phone+"%'";
		List<Bill> blist = new ArrayList<>();
		try {
			Statement smt = Db.getDbConnection().createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next())
			{
				Bill b = new Bill();
				b.setId(Integer.parseInt(rs.getString("id")));
				b.setCustomername(rs.getString("customer_name"));
				b.setDate(rs.getString("date"));
				b.setPid(Integer.parseInt(rs.getString("product_id")));
				b.setMrp(Integer.parseInt(rs.getString("mrp")));
				b.setQuantity(Integer.parseInt(rs.getString("quantity")));
				b.setProductname(rs.getString("product_name"));
				b.setPrice(Integer.parseInt(rs.getString("price")));
			    b.setPhone(rs.getString("phone"));
			    b.setBnumber(Integer.parseInt(rs.getString("bill_number")));
				blist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
		
	}

	@Override
	public List<Bill> displayById(String name, String date, String phone,int bn) {
		String sql = "select id from bill where customer_name='"+name+"'and date ='"+date+"' and phone='"+phone+"' and bill_number='"+bn+"'";
		try {
			Statement stmt = Db.getDbConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) 
			{
				int id=Integer.parseInt(rs.getString("id"));
				String sqll = "select * from bill where id>='"+id+"'";
				List<Bill> blist=new ArrayList<>();
				ResultSet rss = stmt.executeQuery(sqll);
				while (rss.next()) 
				{
					Bill b = new Bill();
					b.setId(Integer.parseInt(rss.getString("id")));
					b.setProductname(rss.getString("product_name"));
					b.setQuantity(Integer.parseInt(rss.getString("quantity")));
					b.setMrp(Integer.parseInt(rss.getString("mrp")));
					b.setPrice(Integer.parseInt(rss.getString("price")));
					blist.add(b);
				}
				return blist;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Bill> searchBillByBillNum(int bnum) {
		String sql = "select * from bill where bill_number='"+bnum+"'";
		List<Bill> blist = new ArrayList<>();
		try {
			Statement smt = Db.getDbConnection().createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next())
			{
				Bill b = new Bill();
				b.setId(Integer.parseInt(rs.getString("id")));
				b.setCustomername(rs.getString("customer_name"));
				b.setDate(rs.getString("date"));
				b.setPid(Integer.parseInt(rs.getString("product_id")));
				b.setMrp(Integer.parseInt(rs.getString("mrp")));
				b.setQuantity(Integer.parseInt(rs.getString("quantity")));
				b.setProductname(rs.getString("product_name"));
				b.setPrice(Integer.parseInt(rs.getString("price")));
			    b.setPhone(rs.getString("phone"));
			    b.setBnumber(Integer.parseInt(rs.getString("bill_number")));
				blist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
	}

	@Override
	public List<Bill> searchBillLikeBillNum(String bnum) {
		String sql = "select * from bill where bill_number like'%"+bnum+"%'";
		List<Bill> blist = new ArrayList<>();
		try {
			Statement smt = Db.getDbConnection().createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next())
			{
				Bill b = new Bill();
				b.setId(Integer.parseInt(rs.getString("id")));
				b.setCustomername(rs.getString("customer_name"));
				b.setDate(rs.getString("date"));
				b.setPid(Integer.parseInt(rs.getString("product_id")));
				b.setMrp(Integer.parseInt(rs.getString("mrp")));
				b.setQuantity(Integer.parseInt(rs.getString("quantity")));
				b.setProductname(rs.getString("product_name"));
				b.setPrice(Integer.parseInt(rs.getString("price")));
			    b.setPhone(rs.getString("phone"));
			    b.setBnumber(Integer.parseInt(rs.getString("bill_number")));
				blist.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
	}

	
	
	
	
	
}
