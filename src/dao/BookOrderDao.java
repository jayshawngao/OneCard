package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.BookOrder;
import jdbc.Connsql;

public class BookOrderDao {

	public static int insert(BookOrder bo){
		int n=0;
		Connsql c=new Connsql();
		Connection conn=c.getConnection();
		try {
			String s="INSERT INTO BookOrder VALUES(default,'"+bo.getISBN()+"',"+bo.getUser()+",default);";
			Statement stmt=conn.createStatement();
			n = stmt.executeUpdate(s);
					stmt.close();
					conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
	public static List<BookOrder> findByUser(int user){
		List<BookOrder> list=new ArrayList<BookOrder>();
		Connsql connsql = new Connsql();
		Connection con = connsql.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM BookOrder WHERE �˻�="+user+";");
				while (rs.next()) {
					BookOrder bo=new BookOrder();
					bo.setId(rs.getInt("������"));
					bo.setISBN(rs.getString("ISBN"));
					bo.setUser(rs.getInt("�˻�"));
					bo.setTs(rs.getTimestamp("����ʱ��"));
					list.add(bo);
				}
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<BookOrder> findByUserAndId(int user,int id){
		List<BookOrder> list=new ArrayList<BookOrder>();
		Connsql connsql = new Connsql();
		Connection con = connsql.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM bookorder WHERE ������="+id+" AND �˻�="+user+";");
				while (rs.next()) {
					BookOrder bo=new BookOrder();
					bo.setId(rs.getInt("������"));
					bo.setISBN(rs.getString("ISBN"));
					bo.setUser(rs.getInt("�˻�"));
					bo.setTs(rs.getTimestamp("����ʱ��"));
					list.add(bo);
				}
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int delete(int id){
		int n = 0;// n=0˵��ɾ�����ɹ�
		try {
			Connsql connsql = new Connsql();
			Connection con = connsql.getConnection();
			Statement stmt = con.createStatement();
			n = stmt.executeUpdate("delete from BookOrder where ������=" +id
					+ ";");
			stmt.close();
			con.close();
		} catch (Exception e) {

		}
		return n;
	}
}
