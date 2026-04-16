package osvaldo.morales.company.demo.java8.exercise.comparable.test;


public class User implements Comparable<User> {

	private Integer userId;
	private String name;
	private String phoneNo;
	public static enum GENERO{
		HOMBRE,MUJER
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(Integer userId, String name, String phoneNo) {
		super();
		this.userId = userId;
		this.name = name;
		this.phoneNo = phoneNo;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public int compareTo(User o) {
		/*
		if(this.getUserId()>o.getUserId()) {
			return 1;
		}
		else if(this.getUserId()<o.getUserId()) {
			return -1;
		}
		else return 0;
		*/
		
		return this.getName().compareTo(o.getName());
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", phoneNo=" + phoneNo + "]";
	}
	
	
	
	
}
