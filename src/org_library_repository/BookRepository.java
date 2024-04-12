package org_library_repository;
import java.util.*;

import org_library_model.BookModel;

public class BookRepository extends DBConfig{
	int value;
  public int getcatIdByName(String catName)
  {
	  try {
		  stmt=conn.prepareStatement("select * from category where cat_name=?");
		  stmt.setString(1, catName);
		  rs=stmt.executeQuery();
		  if(rs.next())
		  {
			  return rs.getInt(1);
		  }
		  else
		  {
			  //System.out.println("Enter Valid Category");
			  return -1;
		  }
	  }
	  catch(Exception ex)
	  {
		  System.out.println("Exception is "+ex);
		  return 0;
	  }
  }
  public boolean isAddBook(BookModel bModel,String catName)
  {
	  try {
		  int catid=this.getcatIdByName(catName);
		  if(catid!=0)
		  {
			  stmt=conn.prepareStatement("insert into books values(?,?,?,?,?,?,?)");
			  stmt.setInt(1, bModel.getBid());
			  stmt.setString(2, bModel.getBname());
			  stmt.setString(3, bModel.getBlang());
			  stmt.setString(4, bModel.getbAuth());
			  stmt.setInt(5,bModel.gettCopies());
			  stmt.setInt(6, bModel.getaCopies());
			  stmt.setInt(7, catid);
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
		  return false;
	  }
	  catch(Exception ex)
	  {
     	  System.out.println("Exception is "+ex);
//		  System.out.println("Enter Valid Category");
		  return false;
	  }
  }
  
  public List<BookModel> viewBooks()
  {
	  List<BookModel> blst=new ArrayList<BookModel>();
	  try {
		  stmt=conn.prepareStatement("select b.b_id,b.b_name,b.b_language,b.b_author,b.total_copies,b.available_copies,c.cat_name from books b inner join category c where c.cat_id=b.cat_id order by b.b_id asc");
		  rs=stmt.executeQuery();
		  while(rs.next())
		  {
			  BookModel bookModel=new BookModel();
			  bookModel.setBid(rs.getInt(1));
			  bookModel.setBname(rs.getString(2));
			  bookModel.setBlang(rs.getString(3));
			  bookModel.setbAuth(rs.getString(4));
			  bookModel.settCopies(rs.getInt(5));
			  bookModel.setaCopies(rs.getInt(6));
			  bookModel.setCat_name(rs.getString(7));
			  blst.add(bookModel);
		  }
		  return blst.size()>0?blst:null;	
		  }
	  catch(Exception ex)
	  {
		  System.out.println("Exception is "+ex);
		  return null;
	  }
  }
  
  public boolean isUpdateBookName(int bookid,String bName)
  {
	  try {
		  stmt=conn.prepareStatement("update books set b_name=? where b_id=?");
		  stmt.setString(1, bName);
		  stmt.setInt(2, bookid);
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
  
  public boolean isDeleteBook(String bookName)
  {
	  try {
		  stmt=conn.prepareStatement("delete from books where b_name=?");
		  stmt.setString(1, bookName);
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
  public List<BookModel> viewCatWiseBook()
  {
	  List<BookModel> lst=new ArrayList<BookModel>();
	  try {
		  stmt=conn.prepareStatement("select c.cat_name,b.b_name from category c inner join books b where c.cat_id=b.cat_id");
		  rs=stmt.executeQuery();
		  while(rs.next())
		  {
			 BookModel bmodel=new BookModel();
			 bmodel.setCat_name(rs.getString(1));
			 bmodel.setBname(rs.getString(2));
			 lst.add(bmodel);
		  }
		  return lst.size()>0?lst:null;
	  }
	  catch(Exception ex)
	  {
		  System.out.println("Exception is "+ex);
		  return null;
	  }
  }
public List<BookModel> viewBookWiseStdCount()
  {
	List<BookModel> lst=new ArrayList<BookModel>();
	try {
		stmt=conn.prepareStatement("select b.b_name,count(i.st_id) from books b inner join issue_book i on b.b_id=i.b_id group by b.b_name");
		rs=stmt.executeQuery();
		while(rs.next())
		{
			BookModel bmodel=new BookModel();
			bmodel.setBname(rs.getString(1));
			bmodel.setCount_stid(rs.getInt(2));
			lst.add(bmodel);
		}
		return lst.size()>0?lst:null;
	}
	catch(Exception ex)
	{
		System.out.println("Exception is "+ex);
		return null;
	}
  }

 public List<BookModel> viewBorrowedBooks(int st_id)
 {
	 List<BookModel> lst=new ArrayList();
	 try {
		 stmt=conn.prepareStatement("select b.b_name from books b inner join issue_book i on b.b_id=i.b_id inner join student s on s.st_id=i.st_id where s.st_id=? and i.status='borrowed'");
		 stmt.setInt(1, st_id);
		 rs=stmt.executeQuery();
		 while(rs.next())
		 {
			BookModel bmodel=new BookModel();
			bmodel.setBname(rs.getString(1));
			lst.add(bmodel);			 
		 }
		 return lst.size()>0?lst:null;
		 
	 }
	 catch(Exception ex)
	 {
		 System.out.println("Exception is "+ex);
		 return null;
	 }
 }
}