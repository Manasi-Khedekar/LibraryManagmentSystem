package org_library_model;
public class CategoryModel {
 private int cat_id;
 private String cat_name;
 private String shelf_name;
 
public CategoryModel()
 {
	 
 }
 public CategoryModel(int cat_id,String cat_name,String shelfName )
 {
	 this.cat_id=cat_id;
	 this.cat_name=cat_name;
 }
public int getCat_id() {
	return cat_id;
}
public void setCat_id(int cat_id) {
	this.cat_id = cat_id;
}
public String getCat_name() {
	return cat_name;
}
public void setCat_name(String cat_name) {
	this.cat_name = cat_name;
}
public String getShelf_name() {
	return shelf_name;
}
public void setShelf_name(String shelf_name) {
	this.shelf_name = shelf_name;
}
}