package com.training.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/trialdb";
		String username  = "root";
		String password = "root";
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(url,username,password);
			 statement = connection.createStatement();
			String sql = "delete from policy where policy_id=560";
		boolean result = statement.execute(sql);
		System.out.println("Table deleted "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null)
					connection.close();
				if(statement!=null)
					statement.close();
					
			} catch(SQLException  e) {
				e.printStackTrace();
			}
		}

	}

	}


