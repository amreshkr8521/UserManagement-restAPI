package com.bridgelabz.usermanagement.businesslogic;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.bridgelabz.usermanagement.model.Permission;
import com.bridgelabz.usermanagement.model.UserBeans;
import com.bridgelabz.usermanagemnet.repository.DatabaseConnectivityRemote;

/**
 * Stateless EJB class to control all the business logics
 * 
 * @author amresh kumar
 * 
 *
 */
@Stateless
public class UserStateless implements UserStatelessRemote {

	@EJB
	DatabaseConnectivityRemote remoteDatabase;

	// constructor
	public UserStateless() {

	}

	/**
	 * To alter the user using the query given
	 * 
	 * @param query String
	 */
	@Override
	public void alterUser(String query) {
		remoteDatabase.executeQuery(query);
	}

	/**
	 * To get the user from the databse
	 * 
	 * @param username String
	 */
	@Override
	public UserBeans getUser(String username) {
		String query = "SELECT * FROM restapiUsers WHERE userName='" + username + "';";
		return remoteDatabase.getUser(query);
	}

	/**
	 * To update the data of the user
	 * 
	 * @param username String
	 * @param field    String
	 * @param data     String
	 */
	@Override
	public void update(String username, String field, String data) {
		String query = "UPDATE restapiUsers SET " + field + "='" + data + "' WHERE userName='" + username + "';";
		remoteDatabase.executeQuery(query);
	}

	/**
	 * to get the registration history from the database
	 * 
	 * @param query String
	 * @return List
	 */
	@Override
	public List<String> getHistory() {
		String query = "SELECT regDate FROM restapiUsers;";
		List<String> date = remoteDatabase.getHistory(query);
		return date;
	}

	/**
	 * to count the number of gender according to the query given.
	 * 
	 * @param query String
	 * @return int
	 */
	@Override
	public float genderPercentage(String gender) {
		String male = "Select Count(gender) FROM restapiUsers WHERE gender='" + gender + "';";
		String genderCount = "SELECT COUNT(gender) FROM restapiUsers ;";
		int totalUser = remoteDatabase.countGender(genderCount);
		
		
		int maleCount = remoteDatabase.countGender(male);
		System.out.println(totalUser+"************************************"+maleCount);
		return (maleCount / totalUser) * 100;
	}

	/**
	 * To login the user and access the permission got
	 * 
	 * @param userName String
	 * @param password String
	 * @return userBeans
	 */
	@Override
	public UserBeans login(String userName, String password) {
		String query = "SELECT * FROM restapiUsers Where userName='" + userName + "' AND password='" + password + "';";
		UserBeans user = remoteDatabase.getUser(query);
		if (user != null)
			return user;
		else
			return null;

	}

	/**
	 * To add the permission to the user according to the admin want to give the
	 * permission.
	 * 
	 * @param permission Permission
	 * @param userId     int
	 */
	@Override
	public void givePermission(Permission permission, int userId) {
		String query = "INSERT INTO permission (userId,dashboard,setting,userinfo,webPage1,webPage2,webPage3) VALUES("
				+ userId + ",'" + permission.getDashboard() + "','" + permission.getSettings() + "','"
				+ permission.getUserInformation() + "','" + permission.getWeb1() + "','" + permission.getWeb2() + "','"
				+ permission.getWeb3() + "');";
		remoteDatabase.executeQuery(query);
	}

}
