package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.Commodity;
import data.CommodityOrder;
import data.User;
import jdbc.Connsql;

public class CommodityDao {
	public static int insert(Commodity c){
		int n=0;
		Connsql co=new Connsql();
		Connection conn=co.getConnection();
		try {
			String s="INSERT INTO commodity VALUES(default,'"+c.getName()+"',default,"+c.getPrice()+");";
			Statement stmt=conn.createStatement();
			n = stmt.executeUpdate(s);
					stmt.close();
					conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
	public static List<Commodity> findAll(){
		List<Commodity> list = new ArrayList<Commodity>();
		Connsql connsql = new Connsql();
		Connection con = connsql.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from commodity;");
				while (rs.next()) {
					Commodity c=new Commodity();
					c.setId(rs.getInt("编号"));
					c.setName(rs.getString("名称"));
					c.setPhoto(rs.getString("图片"));
					c.setPrice(rs.getDouble("价格"));
					list.add(c);	
				}
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Commodity findById(int id){
        Commodity c = new Commodity();
		Connsql connsql = new Connsql();
		Connection con = connsql.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from commodity where 编号="+id+";");
				while (rs.next()) {
					
					c.setId(rs.getInt("编号"));
					c.setName(rs.getString("名称"));
					c.setPhoto(rs.getString("图片"));
					c.setPrice(rs.getDouble("价格"));
						
				}
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public static  Commodity findMax(){
		Commodity c=new Commodity();
		try {
			
			Connsql connsql = new Connsql();
			Connection con = connsql.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Commodity WHERE 编号=(SELECT MAX(编号) FROM commodity);");
			if (rs != null) {
				while (rs.next()) {
					c.setId(rs.getInt("编号"));
					c.setName(rs.getString("名称"));
					c.setPhoto(rs.getString("图片"));
					c.setPrice(rs.getDouble("价格"));
					
				}
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public static int update(Commodity c){
		Connsql connsql = new Connsql();
		Connection con = connsql.getConnection();
		int n = 0;// n=0说明修改不成功
		try {
			
			Statement stmt = con.createStatement();
		
			String string="UPDATE commodity SET 图片='"+c.getPhoto()+"' WHERE 编号="+c.getId()+";";
			n= stmt.executeUpdate(string);
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
			n = stmt.executeUpdate("delete from commodity where 编号 =" +id
					+ ";");
			stmt.close();
			con.close();
		} catch (Exception e) {

		}
		return n;
	}
}
