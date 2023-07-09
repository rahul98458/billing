package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.Db;

import com.model.Sale;

public class SaleServiceImpl implements SaleService{

	@Override
	public boolean saleAdd(Sale s) {
		String sql = "insert into sale(bill_number,date,customer_name,phone,total_amount)values(?,?,?,?,?)";
		try {
			PreparedStatement pstm = Db.getDbConnection().prepareStatement(sql);
			pstm.setInt(1, s.getBillnum());
			pstm.setString(2,s.getDate());
			pstm.setString(3,s.getCname());
			pstm.setString(4,s.getPhone());
			pstm.setInt(5,s.getTotal());
			
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Sale> displaySale() {
		
		String sql = "select * from sale";
		List<Sale> clist = new ArrayList<>();
		try {
			Statement smt = Db.getDbConnection().createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while(rs.next())
			{
				Sale s = new Sale();
				s.setId(Integer.parseInt(rs.getString("id")));
				s.setDate(rs.getString("date"));
				s.setCname(rs.getString("customer_name"));
				s.setPhone(rs.getString("phone"));
				s.setTotal(Integer.parseInt(rs.getString("total_amount")));
				s.setBillnum(Integer.parseInt(rs.getString("bill_number")));
				clist.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clist;
		
	}
   
}
