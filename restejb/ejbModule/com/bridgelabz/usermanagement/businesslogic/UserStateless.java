package com.bridgelabz.usermanagement.businesslogic;

import javax.ejb.EJB;
import javax.ejb.Stateless;

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
		remoteDatabase.alterUser(query);
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
		String query = "UPDATE FROM restapiUsers SET " + field + "='" + data + "' WHERE userName='" + username + "';";
		remoteDatabase.alterUser(query);
	}

}
