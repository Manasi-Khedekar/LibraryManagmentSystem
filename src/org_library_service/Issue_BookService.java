package org_library_service;

import java.util.List;

import org_library_model.Issue_BookModel;
import org_library_repository.Issue_BookRepository;

public class Issue_BookService {
	Issue_BookRepository isRepo=new Issue_BookRepository();
	int diff;
	public int getBookIdByName(String bname)
	{
		return isRepo.getBookIdByName(bname);
	}
	public boolean issue_book(int st_id,int book_id,String status)
	{
		return isRepo.issue_book(st_id,book_id,status);
	}
	public boolean updateAvailableCopies(int book_id) {
		return isRepo.updateAvailableCopies(book_id);
	}
	public boolean returnedBook(int st_id,int book_id,String status )
	{
		return isRepo.returnedBook(st_id,book_id,status);
	}
	public List<Issue_BookModel> showIssueBookDetails(int st_id)
	{
		return isRepo.showIssueBookDetails(st_id);
	}
	public boolean UpdateAvailableCopiesAfterReturn(int book_id) 
	{
		return isRepo.UpdateAvailableCopiesAfterReturn(book_id);
	}
	public List<Issue_BookModel> viewStudentNotRetBook()
	{
		return isRepo.viewStudentNotRetBook();
	}
	public List<Issue_BookModel> showIssueBookToAdmin()
	{
		return isRepo.showIssueBookToAdmin();
	}
	public String getStatus(int st_id,int book_id)
	{
		return isRepo.getStatus(st_id,book_id);
	}
	
}