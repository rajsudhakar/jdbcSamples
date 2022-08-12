package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreInsertScanDemo {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/trialdb";
		String username = "root";
		String password = "root";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Scanner scanner = new Scanner(System.in);
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "insert into food values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			scanner = new Scanner(System.in);
			for (int i = 0; i < 2; i++) {
				System.out.println("Enter food name");
				String name = scanner.next();
				System.out.println("Enter food id");
				int foodId = scanner.nextInt();
				System.out.println("Enter food type");
				String type = scanner.next();
				System.out.println("Enter cost");
				float cost = scanner.nextFloat();

				// set values for the place holders
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, foodId);
				preparedStatement.setString(4, type);
				preparedStatement.setFloat(3, cost);
				preparedStatement.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
