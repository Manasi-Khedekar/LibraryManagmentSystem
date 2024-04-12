package org_library_repository;

import org_library_model.AdminModel;

public class AdminRepository extends DBConfig {
  public boolean verifyAdmin(AdminModel aModel)
  {
	  try {
		   stmt=conn.prepareStatement("select * from admin where username=? and password=?");
		   stmt.setString(1, aModel.getUser());
		   stmt.setString(2, aModel.getPass());
		   rs=stmt.executeQuery();
		   return rs.next();
		  	  
	  }
	  catch(Exception ex)
	  {
		  System.out.println("Error is "+ex);
		  return false;
	  }
  }
}
