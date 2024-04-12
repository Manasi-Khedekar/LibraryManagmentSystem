package org_library_model;
public class AdminModel {
	private String user;
	private String pass;
	public AdminModel(String user,String pass)
	{
	    this.user=user;
	    this.pass=pass;
	}
	public AdminModel()
	{
		
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
}