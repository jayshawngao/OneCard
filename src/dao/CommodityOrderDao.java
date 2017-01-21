package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.Commodity;
import data.CommodityOrder;
import jdbc.Connsql;

public class CommodityOrderDao {
	public static int insert(CommodityOrder co){
		int n=0;
		Connsql c=new Connsql();
		Connection conn=c.getConnection();
		try {
			String s="INSERT INTO commodityorder VALUES(default,"+co.getCommodity()+","+co.getUser()+",default);";
			Statement stmt=conn.createStatement();
			n = stmt.executeUpdate(s);
					stmt.close();
					conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return n;
	}
	
	public static List<CommodityOrder> findByUser(int user){
		List<CommodityOrder> list=new ArrayList<CommodityOrder>();
		Connsql connsql = new Connsql();
		Connection con = connsql.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM commodityorder WHERE 账户="+user+";");
				while (rs.next()) {
					CommodityOrder co=new CommodityOrder();
					co.setId(rs.getInt("订单号"));
					co.setCommodity(rs.getInt("编号"));
					co.setUser(rs.getInt("账户"));
					co.setTs(rs.getTimestamp("创建时间"));
					list.add(co);
				}
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<CommodityOrder> findByUserAndID(int user,int id){
		List<CommodityOrder> list=new ArrayList<CommodityOrder>();
		Connsql connsql = new Connsql();
		Connection con = connsql.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM commodityorder WHERE 账户="+user+" AND 订单号="+id+";");
				while (rs.next()) {
					CommodityOrder co=new CommodityOrder();
					co.setId(rs.getInt("订单号"));
					co.setCommodity(rs.getInt("编号"));
					co.setUser(rs.getInt("账户"));
					co.setTs(rs.getTimestamp("创建时间"));
					list.add(co);
				}
			
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int delete(int id){
		int n = 0;// n=0说明删除不成功
		try {
			Connsql connsql = new Connsql();
			Connection con = connsql.getConnection();
			Statement stmt = con.createStatement();
			n = stmt.executeUpdate("delete from commodityorder where 订单号 =" +id
					+ ";");
			stmt.close();
			con.close();
		} catch (Exception e) {

		}
		return n;
	}

}
