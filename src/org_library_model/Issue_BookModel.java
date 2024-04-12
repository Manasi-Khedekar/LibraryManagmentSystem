package org_library_model;

public class Issue_BookModel {
 private int iss_id;
 private int st_id;
 private int book_id;
 private String iss_date;
 private String due_date;
 private String return_date;
 private String status;
 private int fine;
 private String book_name;
 private String st_name;
 private String st_year;
 
 

public Issue_BookModel()
 {
	 
 }
 public Issue_BookModel(int st_id,int book_id)
 {
	 
	 this.st_id=st_id;
	 this.book_id=book_id;
	 
 }
public int getIss_id() {
	return iss_id;
}
public void setIss_id(int iss_id) {
	this.iss_id = iss_id;
}
public int getSt_id() {
	return st_id;
}
public void setSt_id(int st_id) {
	this.st_id = st_id;
}
public int getBook_id() {
	return book_id;
}
public void setBook_id(int book_id) {
	this.book_id = book_id;
}
public String getIss_date() {
	return iss_date;
}
public void setIss_date(String iss_date) {
	this.iss_date = iss_date;
}
public String getDue_date() {
	return due_date;
}
public void setDue_date(String due_date) {
	this.due_date = due_date;
}
public String getReturn_date() {
	return return_date;
}
public void setReturn_date(String return_date) {
	this.return_date = return_date;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getFine() {
	return fine;
}
public void setFine(int fine) {
	this.fine = fine;
}
public String getBook_name() {
	return book_name;
}
public void setBook_name(String book_name) {
	this.book_name = book_name;
}

public String getSt_name() {
	return st_name;
}
public void setSt_name(String st_name) {
	this.st_name = st_name;
}
public String getSt_year() {
	return st_year;
}
public void setSt_year(String st_year) {
	this.st_year = st_year;
}
}