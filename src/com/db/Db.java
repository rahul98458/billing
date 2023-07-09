package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db {

 public  static Connection getDbConnection() {
		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/billing","root","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
		
	}
	
}
