package data;



public class CommodityOrder {
	private int id;
	private int commodity;
	private int user;
	private java.util.Date ts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCommodity() {
		return commodity;
	}
	public void setCommodity(int commodity) {
		this.commodity = commodity;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public java.util.Date getTs() {
		return ts;
	}
	public void setTs(java.util.Date ts) {
		this.ts = ts;
	}
	public CommodityOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommodityOrder(int id, int commodity, int user, java.util.Date ts) {
		super();
		this.id = id;
		this.commodity = commodity;
		this.user = user;
		this.ts = ts;
	}
	@Override
	public String toString() {
		return "CommodityOrder [id=" + id + ", commodity=" + commodity + ", user=" + user + ", ts=" + ts + "]";
	}
	

}
