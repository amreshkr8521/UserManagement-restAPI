package com.bridgelabz.usermanagement.checkconnection;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.logging.Logger;

import com.bridgelabz.usermanagement.businesslogic.UserStatelessRemote;
import com.bridgelabz.usermanagement.model.UserBeans;

/**
 * To operate all the operation by the User/Admin can access
 * 
 * @author amresh kumar
 * @since
 *
 */

@Path("User")
public class RestController {

	Logger log = Logger.getLogger(RestController.class);

	@EJB
	UserStatelessRemote ejbUser;

	/**
	 * To add the new user
	 * 
	 * @param beans UserBeans
	 * @return String
	 */
	@POST
	@Path("add")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String addUser(UserBeans beans) {
		String query = "INSERT INTO restapiUsers (fname,lname,mname,email,age,gender,user,mobile,location,userName,country,dob,password,regDate) VALUES('"
				+ beans.getfName() + "','" + beans.getmName() + "','" + beans.getlName() + "','" + beans.getEmail()
				+ "','" + beans.getAge() + "','" + beans.getGender() + "','" + beans.getUser() + "','"
				+ beans.getMobile() + "','" + beans.getLocation() + "','" + beans.getUsername() + "','"
				+ beans.getCountry() + "','" + beans.getDob() + "','" + beans.getPassword() + "',now());";
		ejbUser.alterUser(query);
		return "done";
	}

	/**
	 * To delete the user
	 * 
	 * @param bean UserBeans
	 * 
	 */
	@DELETE
	@Path("delete")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteUser(UserBeans bean) {
		String query = "DELETE FROM restapiUsers WHERE username='" + bean.getUsername() + "';";
		ejbUser.alterUser(query);
	}

	/**
	 * To get the user data
	 * 
	 * @param username String
	 * @return UserBeans
	 */
	@GET
	@Path("get/{username}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserBeans getUser(@PathParam("username") String username) {
		return ejbUser.getUser(username);
	}

	/**
	 * To update the user
	 * 
	 * @param username string
	 * @param field    string
	 * @param data     string
	 *
	 */
	@PUT
	@Path("update/{username}/{field}/{data}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateUser(@PathParam("username") String username, @PathParam("field") String field,
			@PathParam("data") String data) {
		ejbUser.update(username, field, data);

	}

	/**
	 * to get the registration history of the user
	 */
	@GET
	@Path("registerUsers")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void userRegistration() {
		List<String> data = ejbUser.getHistory();
	}

	/**
	 * To get the male percentage among the total users
	 * 
	 * @return float
	 */
	@GET
	@Path("malepercents")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public float malePecent() {
		return ejbUser.genderPercentage("male");
	}

	/**
	 * To get the female percentage among the total users
	 * 
	 * @return float
	 */
	@GET
	@Path("femalepercents")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public float femalePecent() {
		return ejbUser.genderPercentage("Female");
	}

	/**
	 * To login the user and access the permission got
	 * 
	 * @param userName String
	 * @param password String
	 * @return String
	 */
	@GET
	@Path("login/{username}/{password}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String login(@PathParam("username") String userName, @PathParam("password") String password) {
		
		UserBeans data = ejbUser.login(userName, password);
		System.out.println("*****************************"+data.getCountry());
		if (data.getUsername().equals(userName))
			return "login done";
		else
			return "something wrong";

	}
}
