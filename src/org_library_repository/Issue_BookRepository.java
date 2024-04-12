package org_library_repository;

import java.util.*;

import org_library_model.Issue_BookModel;

public class Issue_BookRepository extends DBConfig{
	private int isid;
	int value;
	StudentRepository studRepo=new StudentRepository();
  public int getIssueId()
  {
	  try {
		  stmt=conn.prepareStatement("select max(iss_id) from issue_book");
		  rs=stmt.executeQuery();
		  if(rs.next())
		  {
			isid=rs.getInt(1);  
		  }
		  ++isid;
	  }
	  
	  catch(Exception ex)
	  {
		  System.out.println("Exception is "+ex);
		  return 0;
	  }
	  return isid;
  }
  public int getBookIdByName(String bname)
   {
	try {
		stmt=conn.prepareStatement("select b_id from books where b_name=?");
		stmt.setString(1, bname);
		rs=stmt.executeQuery();
		if(rs.next())
		{
			return rs.getInt(1);
		}
	   return 0;
	}
	catch(Exception ex)
	{
		System.out.println("Exception is "+ex);
		return 0;
	}	
   }
  public boolean issue_book(int st_id,int book_id,String status)
  {
	  try {
		    int issid=this.getIssueId();
		    if(issid!=0)
		    {
		    	stmt=conn.prepareStatement("insert into issue_book (iss_id,st_id,b_id,issue_date,due_date,status) values (?,?,?,curdate(),date_add(curdate(),interval 10 day),?)");
		    	stmt.setInt(1, issid);
		    	stmt.setInt(2,st_id);
		    	stmt.setInt(3, book_id);
		    	stmt.setString(4, status);
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
  
  public boolean updateAvailableCopies(int book_id)
  {
	  try {
		  stmt=conn.prepareStatement("update books set available_copies=available_copies-1 where b_id=?");
		  stmt.setInt(1, book_id);
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
public boolean returnedBook(int st_id, int book_id, String status)
  {
	try {
		stmt=conn.prepareStatement("update issue_book set status=?,return_date=curdate(),fine=case when return_date>due_date then datediff(return_date,due_date)*10 else 0 end where st_id=? and b_id=?");
		stmt.setString(1, status);
		stmt.setInt(2, st_id);
		stmt.setInt(3, book_id);
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
		System.out.println("Exception is "+ex);
		return false;
	}
  }
  
public List<Issue_BookModel> showIssueBookDetails(int st_id)
 {
	List<Issue_BookModel> lst=new ArrayList();
	try
	{
		stmt=conn.prepareStatement("select b.b_name,i.issue_date,i.due_date,i.status,i.return_date,i.fine from books b inner join issue_book i on b.b_id=i.b_id where st_id=?");
		stmt.setInt(1, st_id);
		rs=stmt.executeQuery();
		while(rs.next())
		{
			Issue_BookModel iModel=new Issue_BookModel();
			iModel.setBook_name(rs.getString(1));
			iModel.setIss_date(rs.getString(2));
			iModel.setDue_date(rs.getString(3));
			iModel.setStatus(rs.getString(4));
			iModel.setReturn_date(rs.getString(5));
			iModel.setFine(rs.getInt(6));
			lst.add(iModel);			
		}
		return lst.size()>0?lst:null;
	}
	catch(Exception ex)
	{
		System.out.println("Exception is "+ex);
		return null;
	}
 }
public boolean UpdateAvailableCopiesAfterReturn(int book_id)
  {
	try {
		stmt=conn.prepareStatement("update books set available_copies=available_copies+1 where b_id=?");
		stmt.setInt(1, book_id);
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
		System.out.println("Exception is "+ex);
		return false;
	}
  }

 public List<Issue_BookModel> viewStudentNotRetBook()
 {
	 List<Issue_BookModel> lst=new ArrayList();
	 try {
		 stmt=conn.prepareStatement("select s.st_name,s.st_year,ib.issue_date,ib.due_date from student s inner join issue_book ib on s.st_id=ib.st_id where ib.status='borrowed'and ib.due_date<curdate()");
		 rs=stmt.executeQuery();
		 while(rs.next())
		 {
			 Issue_BookModel imodel=new Issue_BookModel();
			 imodel.setSt_name(rs.getString(1));
			 imodel.setSt_year(rs.getString(2));
			 imodel.setIss_date(rs.getString(3));
			 imodel.setDue_date(rs.getString(4));
			 lst.add(imodel);
		 }
		 return lst.size()>0?lst:null;
	 }
	 catch(Exception ex)
	 {
		 System.out.println("Exception is "+ex);
		 return null;
	 }
 }
 
 public List<Issue_BookModel> showIssueBookToAdmin()
 {
	 List<Issue_BookModel> lst=new ArrayList();
	 try {
		 stmt=conn.prepareStatement(" select i.iss_id,s.st_name,b.b_name,s.st_year,i.issue_date,i.due_date,i.status,i.return_date,i.fine from student s inner join issue_book i on s.st_id=i.st_id inner join books b on b.b_id=i.b_id");
		 rs=stmt.executeQuery();
		 while(rs.next())
		 {
			 Issue_BookModel isModel=new Issue_BookModel();
			 isModel.setIss_id(rs.getInt(1));
			 isModel.setSt_name(rs.getString(2));
			 isModel.setBook_name(rs.getString(3));
			 isModel.setSt_year(rs.getString(4));
			 isModel.setIss_date(rs.getString(5));
			 isModel.setDue_date(rs.getString(6));
			 isModel.setStatus(rs.getString(7));
			 isModel.setReturn_date(rs.getString(8));
			 isModel.setFine(rs.getInt(9));
			 lst.add(isModel);			 
		 }
		 return lst.size()>0?lst:null;
	 }
	 catch(Exception ex)
	 {
		 System.out.println("Exception is "+ex);
		 return null;
	 }
 }
 
  public String getStatus(int st_id,int book_id)
  {
	 try {
		 stmt=conn.prepareStatement("select status from issue_book where st_id=? and b_id=?");
		 stmt.setInt(1, st_id);
		 stmt.setInt(2, book_id);
		 rs=stmt.executeQuery();
		 if(rs.next())
		 {
			 System.out.println(rs.getString(1));
			 return rs.getString(1); 
			 
		 }
		 else
		 {
			 return "returned";
		 }
		 
	 }
	 catch(Exception ex)
	 {
		 
		 return null;
	 }
  }

}