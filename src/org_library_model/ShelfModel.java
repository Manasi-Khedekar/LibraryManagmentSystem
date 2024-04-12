package org_library_model;

public class ShelfModel {
	private int shelf_id;
	private String shelf_name;
	
	public ShelfModel(int shelf_id,String shelf_name)
	{
		this.shelf_id=shelf_id;
		this.shelf_name=shelf_name;
	}
	public ShelfModel()
	{
		
	}
	public int getShelf_id() {
		return shelf_id;
	}
	public void setShelf_id(int shelf_id) {
		this.shelf_id = shelf_id;
	}
	public String getShelf_name() {
		return shelf_name;
	}
	public void setShelf_name(String shelf_name) {
		this.shelf_name = shelf_name;
	}
	

}