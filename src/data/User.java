package data;

public class User {
	private String id;
	private String pwd;
	private String name;
	private String sex;
	private int age;
	private String level;
	private double money;
	private String phone;
	private String photo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String pwd, String name, String sex, int age, String level, double money, String phone,
			String photo) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.level = level;
		this.money = money;
		this.phone = phone;
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", name=" + name + ", sex=" + sex + ", age=" + age + ", level="
				+ level + ", money=" + money + ", phone=" + phone + ", photo=" + photo + "]";
	}
	
	
	

}
