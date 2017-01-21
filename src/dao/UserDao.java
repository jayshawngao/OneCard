package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import data.User;
import jdbc.*;

public class UserDao {
	


	public static int insert(User u){
		int n=0;
		Connsql c=new Connsql();
		Connection conn=c.getConnection();
		try {
			Statement stmt= conn.createStatement();
			String s="INSERT INTO USER VALUES(default,'"+u.getPwd()
			+"','"+u.getName()+"','"+u.getSex()+"',"+u.getAge()
			+",'"+u.getLevel()+"',"+u.getMoney()+",'"+u.getPhone()+"','"+u.getPhoto()+"');";
			n = stmt.executeUpdate(s);
					stmt.close();
					conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return n;
	}
	public static  User find(int id){
		User s1=new User();
		try {
			
			Connsql connsql = new Connsql();
			Connection con = connsql.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user where 账户="
					+id+ ";");
			if (rs != null) {
				while (rs.next()) {
					s1.setId(rs.getString("账户"));
					s1.setPwd(rs.getString("密码"));
					s1.setName(rs.getString("姓名"));
					s1.setSex(rs.getString("性别"));
					s1.setAge(rs.getInt("年龄"));
					s1.setLevel(rs.getString("级别"));
					s1.setMoney(rs.getDouble("余额"));
					s1.setPhone(rs.getString("联系方式"));
					s1.setPhoto(rs.getString("头像"));
					
				}
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
	
	public static  User findMax(){
		User s1=new User();
		try {
			
			Connsql connsql = new Connsql();
			Connection con = connsql.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE 账户=(SELECT MAX(账户) FROM USER);");
			if (rs != null) {
				while (rs.next()) {
					s1.setId(rs.getString("账户"));
					s1.setPwd(rs.getString("密码"));
					s1.setName(rs.getString("姓名"));
					s1.setSex(rs.getString("性别"));
					s1.setAge(rs.getInt("年龄"));
					s1.setLevel(rs.getString("级别"));
					s1.setMoney(rs.getDouble("余额"));
					s1.setPhone(rs.getString("联系方式"));
					s1.setPhoto(rs.getString("头像"));
					
				}
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s1;
	}
	
	public static List<User> findAll(){
		List<User> list=new ArrayList<User>();
try {
			
			Connsql connsql = new Connsql();
			Connection con = connsql.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER;");
			if (rs != null) {
				while (rs.next()) {
					User s1=new User();
					s1.setId(rs.getString("账户"));
					s1.setPwd(rs.getString("密码"));
					s1.setName(rs.getString("姓名"));
					s1.setSex(rs.getString("性别"));
					s1.setAge(rs.getInt("年龄"));
					s1.setLevel(rs.getString("级别"));
					s1.setMoney(rs.getDouble("余额"));
					s1.setPhone(rs.getString("联系方式"));
					s1.setPhoto(rs.getString("头像"));
					list.add(s1);
					
				}
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int update(User u){
		int n = 0;// n=0说明修改不成功
		try {
			Connsql connsql = new Connsql();
			Connection con = connsql.getConnection();
			Statement stmt = con.createStatement();
			
			n= stmt.executeUpdate("UPDATE USER SET 密码='"+u.getPwd()+"',姓名='"+u.getName()+"',性别='"+u.getSex()+"',年龄='"+u.getAge()+"',级别='"+u.getLevel()+"',余额="+u.getMoney()+",联系方式='"+u.getPhone()+"',头像='"+u.getPhoto()+"' WHERE 账户="+Integer.parseInt(u.getId())+";");
			stmt.close();
			con.close();
		} catch (Exception e) {

		}
		return n;
	}
	
	public static int delete(int id){
		int n = 0;// n=0说明删除不成功
		try {
			Connsql connsql = new Connsql();
			Connection con = connsql.getConnection();
			Statement stmt = con.createStatement();
			n = stmt.executeUpdate("delete from user where 账户=" +id
					+ ";");
			stmt.close();
			con.close();
		} catch (Exception e) {

		}
		return n;
	}
}
