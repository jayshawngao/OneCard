package jdbc;


import java.sql.*;

public class Connsql {
	public Connsql() {
	}

	// �������ݿ�
	String driver = "com.mysql.jdbc.Driver";
	String user = "root";
	String userPassword = "123456";
	String url = "jdbc:mysql://localhost:3306/card";

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, user, userPassword);
		} catch (Exception e) {
		}
		return con;
	}
}
