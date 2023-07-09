package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.Db;
import com.model.Product;

public class ProductServiceImpl implements ProductService {

	@Override
	public boolean addProduct(Product p) {
		String sql = "insert into product(name,quantity_available,mrp) values(?,?,?)";
		try {
			PreparedStatement pstm = Db.getDbConnection().prepareStatement(sql);
			pstm.setString(1,p.getName());
			pstm.setInt(2,p.getQuantityavailabe());
			pstm.setInt(3,p.getMrp());
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product p) {
		String sql = "update product set name=?,quantity_available=?,mrp=? where id=?";
		try {
			PreparedStatement pstm = Db.getDbConnection().prepareStatement(sql);
			pstm.setString(1,p.getName());
			pstm.setInt(2,p.getQuantityavailabe());
			pstm.setInt(3,p.getMrp());
			pstm.setInt(4,p.getId());
		
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> plist = new ArrayList<>();
		String sql = "select * from product";
		try {
			Statement stmt = Db.getDbConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Product p = new Product();
				p.setId(Integer.parseInt(rs.getString("id")));
				p.setName(rs.getString("name"));
				p.setQuantityavailabe(Integer.parseInt(rs.getString("quantity_available")));
				p.setMrp(Integer.parseInt(rs.getString("mrp")));
				plist.add(p);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}

	@Override
	public boolean addQuantity(Product p) {
		String sql = "update product set name=?,quantity_available=?,mrp=? where id=?";
		try {
			PreparedStatement pstm = Db.getDbConnection().prepareStatement(sql);
			pstm.setString(1,p.getName());
			pstm.setInt(2,p.getQuantityavailabe());
			pstm.setInt(3,p.getMrp());
			pstm.setInt(4,p.getId());
		
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
