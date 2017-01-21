package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.Book;
import jdbc.Connsql;

public class BookDao {

	public static int insert(Book b){
		int n=0;
		Connsql c=new Connsql();
		Connection conn=c.getConnection();
		try {
			String s="INSERT INTO Book VALUES('"+b.getISBN()
			+"','"+b.getName()+"','"+b.getWriter()+"',"+b.getPage()+",'"+b.getDate()+"','"+b.getPublisher()+"',default,"+b.getNum()+")";
			Statement stmt=conn.createStatement();
			n = stmt.executeUpdate(s);
					stmt.close();
					conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
	public static List<Book> findAll(){
		List<Book> list=new ArrayList<Book>();
		
		Connsql connsql = new Connsql();
		Connection con = connsql.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Book;");
				while (rs.next()) {
					Book b=new Book();
					b.setISBN(rs.getString("ISBN"));
					b.setName(rs.getString("书名"));
					b.setWriter(rs.getString("作者"));
					b.setPage(rs.getInt("页数"));
					b.setDate(rs.getDate("出版年"));
					b.setPublisher(rs.getString("出版社"));
					b.setPhoto(rs.getString("图片"));
					b.setNum(rs.getInt("馆存"));
					list.add(b);	
				}
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<Book> findByName(String name){
		List<Book> list=new ArrayList<Book>();
		Connsql connsql = new Connsql();
		Connection con = connsql.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Book where 书名='"+name+"';");
				while (rs.next()) {
					Book b=new Book();
					b.setISBN(rs.getString("ISBN"));
					b.setName(rs.getString("书名"));
					b.setWriter(rs.getString("作者"));
					b.setPage(rs.getInt("页数"));
					b.setDate(rs.getDate("出版年"));
					b.setPublisher(rs.getString("出版社"));
					b.setPhoto(rs.getString("图片"));
					b.setNum(rs.getInt("馆存"));
					list.add(b);	
				}
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Book findByISBN(String ISBN){
		Book b=new Book();
		Connsql connsql = new Connsql();
		Connection con = connsql.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Book where ISBN='"+ISBN+"';");
				while (rs.next()) {
					b.setISBN(rs.getString("ISBN"));
					b.setName(rs.getString("书名"));
					b.setWriter(rs.getString("作者"));
					b.setPage(rs.getInt("页数"));
					b.setDate(rs.getDate("出版年"));
					b.setPublisher(rs.getString("出版社"));
					b.setPhoto(rs.getString("图片"));
					b.setNum(rs.getInt("馆存"));
				}
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public static int update(Book b){
		Connsql connsql = new Connsql();
		Connection con = connsql.getConnection();
		int n = 0;// n=0说明修改不成功
		try {
			
			Statement stmt = con.createStatement();
		
			String string="UPDATE Book SET 馆存="+b.getNum()+",图片='"+b.getPhoto()+"' WHERE ISBN='"+b.getISBN()+"';";
			n= stmt.executeUpdate(string);
			stmt.close();
			con.close();
		} catch (Exception e) {

		}
		return n;
	}
	
	public static int delete(String ISBN){
		int n = 0;// n=0说明删除不成功
		try {
			Connsql connsql = new Connsql();
			Connection con = connsql.getConnection();
			Statement stmt = con.createStatement();
			n = stmt.executeUpdate("delete from Book where ISBN='" +ISBN
					+ "';");
			stmt.close();
			con.close();
		} catch (Exception e) {

		}
		return n;
	}
}
