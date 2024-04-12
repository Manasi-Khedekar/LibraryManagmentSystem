package org_library_repository;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.*;

import org_library_pathhelper.pathHelper;

 class DBConfig {
	 protected Connection conn;
	  protected PreparedStatement stmt;
	  protected ResultSet rs;
	  public DBConfig()
	  {
		  try {
			  pathHelper phelp=new pathHelper();			
			  Class.forName(pathHelper.p.getProperty("driver"));
			  conn=DriverManager.getConnection(pathHelper.p.getProperty("url"),pathHelper.p.getProperty("user"),pathHelper.p.getProperty("pass"));
			  
		  }catch(Exception ex)
		  {
			  System.out.println("Error is "+ex);
		  }
	  }
}
