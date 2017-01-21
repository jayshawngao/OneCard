package data;



public class BookOrder {
	private int id;
	private String ISBN;
	private int user;
	private java.util.Date ts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
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
	public BookOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookOrder(int id, String iSBN, int user, java.util.Date ts) {
		super();
		this.id = id;
		ISBN = iSBN;
		this.user = user;
		this.ts = ts;
	}
	@Override
	public String toString() {
		return "ManageBookOrder [id=" + id + ", ISBN=" + ISBN + ", user=" + user + ", ts=" + ts + "]";
	}
	

}
