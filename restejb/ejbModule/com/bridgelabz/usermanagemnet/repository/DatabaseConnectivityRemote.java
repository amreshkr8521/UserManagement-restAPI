package com.bridgelabz.usermanagemnet.repository;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Remote;

import com.bridgelabz.usermanagement.model.UserBeans;

/**
 * Service class for the DatabaseConnectivity class
 * 
 * @author amresh kumar
 *
 */
@Remote
public interface DatabaseConnectivityRemote {
	public Connection jdbcConnection();

	public UserBeans getUser(String query);

	void executeQuery(String query);

	public List<String> getHistory(String query);

	public int countGender(String query);

}
