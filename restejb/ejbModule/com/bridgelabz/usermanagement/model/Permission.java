package com.bridgelabz.usermanagement.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Bean class for the permission of the user.
 * 
 * @author amresh kumar
 *
 */
@XmlRootElement
public class Permission {
	private String dashboard;
	private String Settings;
	private String UserInformation;
	private String web1;
	private String web2;

	public Permission() {
		super();
	}

	public String getDashboard() {
		return dashboard;
	}

	public void setDashboard(String dashboard) {
		this.dashboard = dashboard;
	}

	public String getSettings() {
		return Settings;
	}

	public void setSettings(String settings) {
		Settings = settings;
	}

	public String getUserInformation() {
		return UserInformation;
	}

	public void setUserInformation(String userInformation) {
		UserInformation = userInformation;
	}

	public String getWeb1() {
		return web1;
	}

	public void setWeb1(String web1) {
		this.web1 = web1;
	}

	public String getWeb2() {
		return web2;
	}

	public void setWeb2(String web2) {
		this.web2 = web2;
	}

	public String getWeb3() {
		return web3;
	}

	public void setWeb3(String web3) {
		this.web3 = web3;
	}

	private String web3;

}
