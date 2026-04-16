package osvaldo.morales.company.demo.java8.exercise.test;

import java.util.Comparator;

public class User implements Comparator<User> {

	private Integer userId;
	private String name;
	private String phoneNo;
	
	
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
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}


	
	
}
