package org_library_service;

import java.util.List;
import org_library_model.BookModel;
import org_library_repository.BookRepository;

public class BookService {
	BookRepository bRepo=new BookRepository();
	public boolean isAddBook(BookModel bModel,String catName)
	{
		return bRepo.isAddBook(bModel,catName);
	}
	public List<BookModel> viewBooks()
	{
		return bRepo.viewBooks();
	}
	public boolean isUpdateBookName(int bookid,String bName)
	{
		return bRepo.isUpdateBookName(bookid,bName);
	}
	public boolean isDeleteBook(String bookName)
	{
		return bRepo.isDeleteBook(bookName);
	}
	public List<BookModel> viewCatWiseBook()
	{
		return bRepo.viewCatWiseBook();
	}
	public List<BookModel> viewBookWiseStdCount()
	{
		return bRepo.viewBookWiseStdCount();
	}
	public List<BookModel> viewBorrowedBooks(int st_id)
	{
		return bRepo.viewBorrowedBooks(st_id)!=null?bRepo.viewBorrowedBooks(st_id):null;
	}
	
}