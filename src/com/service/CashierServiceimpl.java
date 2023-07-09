package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.Db;
import com.model.Cashier;

public class CashierServiceimpl implements CashierService{

	@Override
	public boolean addCashier(Cashier c) {
		String sql = "insert into cashier(name,username,mobile,address,email,password)values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstm = Db.getDbConnection().prepareStatement(sql);
			pstm.setString(1,c.getName());
			pstm.setString(2,c.getUsername());
			pstm.setString(3,c.getMobile());
			pstm.setString(4,c.getAddress());
			pstm.setString(5,c.getEmail());
			pstm.setString(6,c.getPassword());
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	

	@Override
	public boolean deleteCashier(int id) {
		String sql = "delete  from cashier where id = '"+id+"'";
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


	public List<Cashier> displayCashier() {
		String sql = "select * from cashier";
		List<Cashier> clist = new ArrayList<>();
		try {
			Statement smt = Db.getDbConnection().createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next())
			{
				Cashier cc = new Cashier();
				cc.setId(rs.getInt("id"));
				cc.setName(rs.getString("name"));
				cc.setUsername(rs.getString("username"));
				cc.setAddress(rs.getString("address"));
				cc.setEmail(rs.getString("email"));
				cc.setMobile(rs.getString("mobile"));
				cc.setPassword(rs.getString("password"));
				clist.add(cc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clist;
	}




	@Override
	public boolean updateCashier(Cashier c) {
	      
		String sql = "update cashier set name=?,username=?,mobile=?,address=?,email=?,password=? where id=?";
		try {
			PreparedStatement pstm = Db.getDbConnection().prepareStatement(sql);
			pstm.setString(1,c.getName());
			pstm.setString(2,c.getUsername());
			pstm.setString(3,c.getMobile());
			pstm.setString(4,c.getAddress());
			pstm.setString(5,c.getEmail());
			pstm.setString(6,c.getPassword());
			pstm.setInt(7,c.getId());
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	
	
	 
}
