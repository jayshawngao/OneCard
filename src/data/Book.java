package data;

import java.sql.Timestamp;

import util.TimeStampToString;

public class Book {
	private String ISBN;
	private String name;
	private String writer;
	private int page;
	//private java.sql.Timestamp date;
	private java.sql.Date date;
	private String photo;
	private int num;
	private String publisher;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String iSBN, String name, String writer, int page, java.sql.Date date,
			String publisher, String photo, int num) {
		super();
		ISBN = iSBN;
		this.name = name;
		this.writer = writer;
		this.page = page;
		this.date = date;
		this.photo = photo;
		this.num = num;
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "ManageBook [ISBN=" + ISBN + ", name=" + name + ", writer=" + writer + ", page=" + page + ", date=" + date
				+ ", photo=" + photo + ", num=" + num + ", publisher=" + publisher + "]";
	}
	
	

}
