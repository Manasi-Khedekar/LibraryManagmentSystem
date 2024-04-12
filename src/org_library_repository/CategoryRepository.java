package org_library_repository;
import java.util.*;
import org_library_model.CategoryModel;

public class CategoryRepository extends DBConfig{
	int value;
  public int getShelfIdByName(String shelfName)
  {
	  try {
		  stmt=conn.prepareStatement("select * from shelf where shelf_name=?");
		  stmt.setString(1, shelfName);
		  rs=stmt.executeQuery();
		  if(rs.next())
		  {
			  return rs.getInt(1);
		  }
		  else
		  {
			  return -1;
		  }
	  }
	  catch(Exception ex)
	  {
		  System.out.println("Error is "+ex);
		  return 0;		  
	  }
  }
  public boolean addCategory(CategoryModel catModel,String shelfName)
  {
	  
	  try {
		   int shelfId=this.getShelfIdByName(shelfName);
		   if(shelfId!=0)
		   {
			   stmt=conn.prepareStatement("insert into category values(?,?,?)");
			   stmt.setInt(1, catModel.getCat_id());
			   stmt.setString(2, catModel.getCat_name());
			   stmt.setInt(3, shelfId);
			   value=stmt.executeUpdate();
			   if(value>0)
			   {
				   return true;
			   }
			   else
			   {
				   return false;
			   }
		   }
		   else if(shelfId==-1)
		   {
			   System.out.println("shelf name not found....");
		   }
		   else
		   {
			   System.out.println("some problem is there...");
			   return false;
		   }
		  return false;
	  }
	  catch(Exception ex)
	  {
		  System.out.println("Exception is "+ex);
		  return false;
	  }
  }
  
//  public int getCatNamebyShelfId(String shelfName)
//  {
//	  try {
//		  stmt=conn.prepareStatement("select s.shelf_name from shelf s inner join category c on s.shelf_id=c.shelf_id ");
//		  rs=stmt.executeQuery();
//		  if(rs.next())
//		  {
//			  return rs.getString(1);
//		  }
//		  else
//		  {
//			  return -1;
//		  }
//	  }
//	  catch(Exception ex)
//	  {
//		  System.out.println("Error is "+ex);
//		  return 0;		  
//	  }
//  }
  public List<CategoryModel> viewCategory()
  {
	  List<CategoryModel> catList=new ArrayList<CategoryModel>();
	  try {
		  stmt=conn.prepareStatement("select c.cat_id,c.cat_name,s.shelf_name from shelf s inner join category c on s.shelf_id=c.shelf_id");
		  rs=stmt.executeQuery();
		  while(rs.next())
		  {
			  CategoryModel cModel=new CategoryModel();
			  cModel.setCat_id(rs.getInt(1));
			  cModel.setCat_name(rs.getString(2));
			  cModel.setShelf_name(rs.getString(3));
			  catList.add(cModel);
		  }
		  return catList.size()>0?catList:null;
	  }
	  catch(Exception ex)
	  {
		  System.out.println("Error is "+ex);
		  return null;
	  }
  }
  
  public boolean updateCategory(int catId,String catName)
  {
	  try {
		  stmt=conn.prepareStatement("update category set cat_name=? where cat_id=?");
		  stmt.setString(1, catName);
		  stmt.setInt(2, catId);
		  value=stmt.executeUpdate();
		  if(value>0)
		  {
			  return true;
		  }
		  else
		  {
			  return false;
		  }
		  
	  }
	  catch(Exception ex)
	  {
		  System.out.println("Error is "+ex);
		  return false;
	  }
  }
  
  public boolean deleteCategory(String catname)
  {
	  try {
		  stmt=conn.prepareStatement("delete from category where cat_name=?");
		  stmt.setString(1, catname);
          value=stmt.executeUpdate();
          if(value>0)
          {
        	  return true;
          }
          else
          {
        	  return false;
          }
	  }
	  catch(Exception ex)
	  {
		  System.out.println("Error is "+ex);
		  return false;
	  }
  }
}