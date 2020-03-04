package com.bridgelabz.usermanagement.businesslogic;

import java.util.List;

import javax.ejb.Remote;

import com.bridgelabz.usermanagement.model.Permission;
import com.bridgelabz.usermanagement.model.UserBeans;

/**
 * Service class for the UserStateless
 * 
 * @author amresh kumar
 *
 */
@Remote
public interface UserStatelessRemote {

	public void alterUser(String query);

	public UserBeans getUser(String query);

	public void update(String username, String field, String data);

	public List<String> getHistory();

	public float genderPercentage(String gender);

	public UserBeans login(String userName, String password);

	public void givePermission(Permission permission, int userId);
}
