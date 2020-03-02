package com.bridgelabz.usermanagemnet.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.bridgelabz.usermanagement.model.UserBeans;

/**
 * To control the curd operation from the table
 * 
 * @author amresh kumar
 *
 */
@Stateless
public class DatabaseConnectivity implements DatabaseConnectivityRemote {
	UserBeans user;

	/**
	 * Establish jdbc connection
	 * 
	 */
	@Override
	public Connection jdbcConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restapi", "root", "12345");
			return connection;

		} catch (Exception e) {
			System.out.println("connection failed");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * to get the user data
	 * 
	 * @param query String
	 */
	@Override
	public UserBeans getUser(String query) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = jdbcConnection().prepareStatement(query);
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				user = new UserBeans();
				user.setfName(resultset.getString(2));
				user.setmName(resultset.getString(10));
				user.setlName(resultset.getString(3));
				user.setEmail(resultset.getString(4));
				user.setGender(resultset.getString(6));
				user.setCountry(resultset.getString(12));
				user.setLocation(resultset.getString(9));
				user.setPassword(resultset.getString(14));
				user.setUser(resultset.getString(7));
				user.setUsername(resultset.getString(11));
				user.setAge(resultset.getInt(5));
				user.setDob(resultset.getString(13));
				user.setMobile(resultset.getLong(8));
				// user.setExtmobile(15);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return user;
	}

	/**
	 * To alter the user
	 * 
	 * @param query String
	 */
	@Override
	public void alterUser(String query) {
		Connection connection = jdbcConnection();
//		String query="DELETE FROM restapiUsers WHERE username='"+bean.getUsername()+"';";
//		String query="INSERT INTO restapiUsers (fname,lname,mname,email,age,gender,user,mobile,location,userName,country,dob) VALUES('"+user.getfName()+"','"+user.getmName()+"','"+user.getlName()+"','"+user.getGmail()+"','"+user.getAge()+"','"+user.getGender()+"','"+user.getUser()+"','"+user.getMobile()+"','"+user.getLocation()+"','"+user.getUsername()+"','"+user.getCountry()+",',"+user.getDob()+"'); ";

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

		}
	}

	/**
	 * to get the registration history from the database
	 * 
	 * @param query String
	 * @return List
	 */
	@Override
	public List<String> getHistory(String query) {
		List<String> list = new ArrayList<String>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = jdbcConnection().prepareStatement(query);
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				list.add(resultset.getString(1));
			}
		} catch (SQLException e) {
			e.getMessage();
		}

		return list;
	}

	/**
	 * to count the number of gender according to the query given.
	 * 
	 * @param query String
	 * @return int
	 */
	@Override
	public int countGender(String query) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = jdbcConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			int count = resultSet.getInt(1);
		} catch (Exception e) {

		}

		return 0;
	}

}
