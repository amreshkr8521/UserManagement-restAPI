package com.bridgelabz.usermanagement.model;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Bean class to store the user information
 * 
 * @author amresh kumar
 *
 */
@XmlRootElement
@Remote
public class UserBeans implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fName;
	private String mName;
	private String lName;
	private String email;
	private String gender;
	private String location;
	private String country;
	private int age;
	private long mobile;
	private long extmobile;

	@Override
	public String toString() {
		return "UserBeans [fName=" + fName + ", mName=" + mName + ", lName=" + lName + ", email=" + email + ", gender="
				+ gender + ", location=" + location + ", country=" + country + ", age=" + age + ", mobile=" + mobile
				+ ", extmobile=" + extmobile + ", password=" + password + ", user=" + user + ", username=" + username
				+ ", dob=" + dob + "]";
	}

	private String password;
	private String user;
	private String username;
	private String dob;

	public UserBeans() {
		super();
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public long getExtmobile() {
		return extmobile;
	}

	public void setExtmobile(long extmobile) {
		this.extmobile = extmobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
}
