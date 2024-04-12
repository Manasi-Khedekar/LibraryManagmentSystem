package org_library_repository;
import java.util.*;
import org_library_model.ShelfModel;

public class ShelfRepository extends DBConfig {
	int value;
/*	private int shelfId;
	
	public int getShelfId()
	{
		try {
			stmt=conn.prepareStatement("select max(shelf_id) from shelf");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				shelfId=rs.getInt(1);
			}
			++shelfId;
		}
		catch(Exception ex)
		{
			System.out.println("Exception is "+ex);
			return 0;
		}
		return shelfId;
	}*/
  public boolean setShelf(ShelfModel shModel)
  {
	  try {
//		   int shelf_id=this.getShelfId();
//		   if(shelf_id !=0)
//		   {
			   stmt=conn.prepareStatement("insert into shelf values(?,?)");
			   stmt.setInt(1, shModel.getShelf_id());
			   stmt.setString(2, shModel.getShelf_name());
			   value=stmt.executeUpdate();
			   if(value>0)
			   {
				   return true;
			   }
			   else
			   {
				   return false;
			   }
//		   }
//		   return false;
	  }
	  catch(Exception ex)
	  {
		  System.out.println("Error is "+ex);
		  return false;
	  }
  }
  
  public List<ShelfModel> ViewShelf()
  {
	  List<ShelfModel> sfModel=new ArrayList<ShelfModel>();
	 try {
		 stmt=conn.prepareStatement("select * from shelf order by shelf_id asc");
		 rs=stmt.executeQuery();
		 while(rs.next())
		 {
			 ShelfModel sh=new ShelfModel();
			 sh.setShelf_id(rs.getInt(1));
			 sh.setShelf_name(rs.getString(2));
			 sfModel.add(sh);
			 
		 }
		 return sfModel.size()>0?sfModel:null;
	 }
	 catch(Exception ex)
	 {
		 System.out.println("Exception is "+ex);
		 return null;
	 }
  }
  
  public boolean isUpdateShelf(int sheid,String sheName)
  {
	  try {
		  stmt=conn.prepareStatement("update shelf set shelf_name=? where shelf_id=?");
          stmt.setString(1, sheName);
          stmt.setInt(2, sheid);
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

  public boolean deleteShelfName(String shelfName) 
  {
	try {
		stmt=conn.prepareStatement("delete from shelf where shelf_name=?");
		stmt.setString(1, shelfName);
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



