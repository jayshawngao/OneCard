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
			ResultSet rs = stmt.executeQuery("select * from user where �˻�="
					+id+ ";");
			if (rs != null) {
				while (rs.next()) {
					s1.setId(rs.getString("�˻�"));
					s1.setPwd(rs.getString("����"));
					s1.setName(rs.getString("����"));
					s1.setSex(rs.getString("�Ա�"));
					s1.setAge(rs.getInt("����"));
					s1.setLevel(rs.getString("����"));
					s1.setMoney(rs.getDouble("���"));
					s1.setPhone(rs.getString("��ϵ��ʽ"));
					s1.setPhoto(rs.getString("ͷ��"));
					
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE �˻�=(SELECT MAX(�˻�) FROM USER);");
			if (rs != null) {
				while (rs.next()) {
					s1.setId(rs.getString("�˻�"));
					s1.setPwd(rs.getString("����"));
					s1.setName(rs.getString("����"));
					s1.setSex(rs.getString("�Ա�"));
					s1.setAge(rs.getInt("����"));
					s1.setLevel(rs.getString("����"));
					s1.setMoney(rs.getDouble("���"));
					s1.setPhone(rs.getString("��ϵ��ʽ"));
					s1.setPhoto(rs.getString("ͷ��"));
					
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
					s1.setId(rs.getString("�˻�"));
					s1.setPwd(rs.getString("����"));
					s1.setName(rs.getString("����"));
					s1.setSex(rs.getString("�Ա�"));
					s1.setAge(rs.getInt("����"));
					s1.setLevel(rs.getString("����"));
					s1.setMoney(rs.getDouble("���"));
					s1.setPhone(rs.getString("��ϵ��ʽ"));
					s1.setPhoto(rs.getString("ͷ��"));
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
		int n = 0;// n=0˵���޸Ĳ��ɹ�
		try {
			Connsql connsql = new Connsql();
			Connection con = connsql.getConnection();
			Statement stmt = con.createStatement();
			
			n= stmt.executeUpdate("UPDATE USER SET ����='"+u.getPwd()+"',����='"+u.getName()+"',�Ա�='"+u.getSex()+"',����='"+u.getAge()+"',����='"+u.getLevel()+"',���="+u.getMoney()+",��ϵ��ʽ='"+u.getPhone()+"',ͷ��='"+u.getPhoto()+"' WHERE �˻�="+Integer.parseInt(u.getId())+";");
			stmt.close();
			con.close();
		} catch (Exception e) {

		}
		return n;
	}
	
	public static int delete(int id){
		int n = 0;// n=0˵��ɾ�����ɹ�
		try {
			Connsql connsql = new Connsql();
			Connection con = connsql.getConnection();
			Statement stmt = con.createStatement();
			n = stmt.executeUpdate("delete from user where �˻�=" +id
					+ ";");
			stmt.close();
			con.close();
		} catch (Exception e) {

		}
		return n;
	}
}
