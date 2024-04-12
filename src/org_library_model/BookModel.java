package org_library_model;

public class BookModel {
 private int bid;
 private String bname;
 private String blang;
 private String bAuth;
 private int tCopies;
 private int aCopies;
 private String Cat_name;
 private int count_stid;
 

public BookModel()
 {
	 
 }
 public BookModel(int bid,String bname,String blang,String bAuth,int tCopies,int aCopies)
 {
	 this.bid=bid;
	 this.bname=bname;
	 this.blang=blang;
	 this.bAuth=bAuth;
	 this.tCopies=tCopies;
	 this.aCopies=aCopies;
 }
public int getBid() {
	return bid;
}
public void setBid(int bid) {
	this.bid = bid;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getBlang() {
	return blang;
}
public void setBlang(String blang) {
	this.blang = blang;
}
public String getbAuth() {
	return bAuth;
}
public void setbAuth(String bAuth) {
	this.bAuth = bAuth;
}
public int gettCopies() {
	return tCopies;
}
public void settCopies(int tCopies) {
	this.tCopies = tCopies;
}
public int getaCopies() {
	return aCopies;
}
public void setaCopies(int aCopies) {
	this.aCopies = aCopies;
}
public String getCat_name() {
	return Cat_name;
}
public void setCat_name(String cat_name) {
	Cat_name = cat_name;
}


public int getCount_stid() {
	return count_stid;
}
public void setCount_stid(int count_stid) {
	this.count_stid = count_stid;
}

}