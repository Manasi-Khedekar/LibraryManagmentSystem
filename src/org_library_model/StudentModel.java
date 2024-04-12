package org_library_model;

public class StudentModel {
 private int stid;
 private String stname;
 private String stcontact;
 private String stemail;
 private String styear;
 private String username;
 private String password;
 public StudentModel()
 {
	 
 }
 public StudentModel(int stid,String stname,String stcontact,String stemail,String styear,String username,String password)
 {
	 this.stid=stid;
	 this.stname=stname;
	 this.stcontact=stcontact;
	 this.stemail=stemail;
	 this.styear=styear;
	 this.username=username;
	 this.password=password;
 }
public int getStid() {
	return stid;
}
public void setStid(int stid) {
	this.stid = stid;
}
public String getStname() {
	return stname;
}
public void setStname(String stname) {
	this.stname = stname;
}
public String getStcontact() {
	return stcontact;
}
public void setStcontact(String stcontact) {
	this.stcontact = stcontact;
}
public String getStemail() {
	return stemail;
}
public void setStemail(String stemail) {
	this.stemail = stemail;
}
public String getStyear() {
	return styear;
}
public void setStyear(String styear) {
	this.styear = styear;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}