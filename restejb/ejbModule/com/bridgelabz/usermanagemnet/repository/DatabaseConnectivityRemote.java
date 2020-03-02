package com.bridgelabz.usermanagemnet.repository;

import java.sql.Connection;

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

	void alterUser(String query);

}
