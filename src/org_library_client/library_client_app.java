package org_library_client;
import java.util.*;

import org_library_model.AdminModel;
import org_library_model.BookModel;
import org_library_model.CategoryModel;
import org_library_model.Issue_BookModel;
import org_library_model.ShelfModel;
import org_library_model.StudentModel;
import org_library_pathhelper.pathHelper;
import org_library_service.AdminService;
import org_library_service.BookService;
import org_library_service.CategoryService;
import org_library_service.Issue_BookService;
import org_library_service.ShelfService;
import org_library_service.StudentService;
public class library_client_app {
	public static void main(String[] args) {
		// pathHelper phelp=new pathHelper();
		int choice;
		AdminService aService = new AdminService();
		ShelfService shService = new ShelfService();
		CategoryService catService = new CategoryService();
		BookService bService = new BookService();
		StudentService studService = new StudentService();
		Issue_BookService isService=new Issue_BookService();
		Scanner sc = new Scanner(System.in);
		boolean b;
		System.out.println("1.Admin");
		System.out.println("2.Student");
		System.out.println("Enter the choice");
		choice = sc.nextInt();
		switch (choice) {
			case 1 :
				sc.nextLine();
				System.out.println("Enter username and password");
				String user = sc.nextLine();
				String pass = sc.nextLine();
				int choice1;
				AdminModel amodel = new AdminModel(user, pass);
				b = aService.verifyAdmin(amodel);
				if (b) {
					System.out.println("valid admin.....");
					do {
						System.out.println(
								"______________________________________________");
						System.out.println("1. Book Shelfs");
						System.out.println("2. Category of books");
						System.out.println("3. Books");
						System.out.println("4. Student Information");
						System.out.println("5. view issue book details");
						System.out.println("6. view category wise books");
						System.out.println("7. view book wise student count");
						System.out.println("8. view student who have not return book after due date");
						System.out.println("Enter 0 to exit the system");
						System.out.println("Enter the choice");
						choice1 = sc.nextInt();
						switch (choice1) {
							case 0:
								    break;
							case 1 : // Book Shelfs
								System.out.println(
										"______________________________________________");
								System.out.println("1. create Book Shelf");
								System.out.println("2. view Book Shelf");
								System.out.println("3. Update Book Shelf");
								System.out.println("4. Delete Book Shelf");
								System.out.println("Enter your choice");
								int choice2 = sc.nextInt();
								switch (choice2) {
									
									case 1 :
										sc.nextLine();
										System.out.println(
												"Enter the Shelf id and Shelf Name");
										int shelf_id = sc.nextInt();
										sc.nextLine();
										String shelf_name = sc.nextLine();
										ShelfModel shModel = new ShelfModel(
												shelf_id, shelf_name);
										b = shService.setShelf(shModel);
										if (b) {
											System.out.println(
													"Shelf added successfully....");
										} else {
											System.out.println(
													"some problem occur during shelf addition....");
										}
										break;

									case 2 :
										// sc.nextLine();
										List<ShelfModel> shList = shService
												.viewShelf();
										System.out.println("shelf_id" + "\t"
												+ "shelf_name");
										for (ShelfModel s : shList) {
											System.out.println(s.getShelf_id()
													+ "\t\t"
													+ s.getShelf_name());
										}
										break;

									case 3 :
										sc.nextLine();
										System.out.println(
												"Enter the id and new shelf name");
										int sheid = sc.nextInt();
										sc.nextLine();
										String shName = sc.nextLine();
										b = shService.isUpdateShelf(sheid,
												shName);
										if (b) {
											System.out.println(
													"Updated successfully.....");
										} else {
											System.out.println(
													"some error occurs...");
										}
										break;

									case 4 :
										sc.nextLine();
										System.out.println(
												"Enter the name of shelf you want to delete");
										String ShelfName = sc.nextLine();
										b = shService
												.deleteShelfName(ShelfName);
										if (b) {
											System.out.println(
													"book shelf deleted successfully....");
										} else {
											System.out.println(
													"some error occur...");
										}
										break;
								}
								break;
							case 2 : // category of books
								sc.nextLine();
								System.out.println(
										"______________________________________________");
								System.out.println("1. Add category of books");
								System.out.println("2. View category of books");
								System.out.println(
										"3. update the category of books");
								System.out.println(
										"4. delete the category of books");
								System.out.println("Enter your choice");
								choice = sc.nextInt();
								switch (choice) {
									case 1 :
										sc.nextLine();
										System.out.println(
												"Enter the category id, category name and shelf name");
										int cat_id = sc.nextInt();
										sc.nextLine();
										String cat_name = sc.nextLine();
										String shelfName = sc.nextLine();
										CategoryModel catModel = new CategoryModel(
												cat_id, cat_name, shelfName);
										b = catService.addCategory(catModel,
												shelfName);
										if (b) {
											System.out.println(
													"category added successfully.....");
										} else {
											System.out.println(
													"some error occur during addition of category...");
										}
										break;

									case 2 :
										sc.nextLine();
										List<CategoryModel> cList = catService
												.viewCategory();
										System.out.println("Category_id" + "\t"
												+ "category_name" + "\t"
												+ "shelf name");
										for (CategoryModel c : cList) {
											System.out.println(c.getCat_id()
													+ "\t\t" + c.getCat_name()
													+ "\t\t"
													+ c.getShelf_name());
										}
										break;

									case 3 :
										sc.nextLine();
										System.out.println(
												"Enter the category id and new category name");
										int catId = sc.nextInt();
										sc.nextLine();
										String catName = sc.nextLine();
										b = catService.updateCategory(catId,
												catName);
										if (b) {
											System.out.println(
													"category name update successfully....");
										} else {
											System.out.println(
													"some error occur during updation of category...");
										}
										break;

									case 4 :
										sc.nextLine();
										System.out.println(
												"Enter the category name which you want to delete");
										String catname = sc.nextLine();
										b = catService.deleteCategory(catname);
										if (b) {
											System.out.println(
													"category deleted successfully...");
										} else {
											System.out.println(
													"some error occur during deletion of category...");
										}
										break;
								}
								break;

							case 3 : // add books
								sc.nextLine();
								System.out.println(
										"______________________________________________");
								System.out.println("1. Add books");
								System.out.println("2. view all books");
								System.out.println(
										"3. update name of book by id");
								System.out.println("4. delete books");
								System.out.println("Enter the choice");
								int choice3 = sc.nextInt();
								switch (choice3) {
									case 1 :
										System.out.println("Enter the book id");
										int bid = sc.nextInt();
										sc.nextLine();
										System.out
												.println("Enter the book name");
										String bname = sc.nextLine();
										System.out.println(
												"Enter the book language");
										String blang = sc.nextLine();
										System.out.println(
												"Enter the author name");
										String bAuth = sc.nextLine();
										System.out.println(
												"Enter the total copies");
										int tCopies = sc.nextInt();
										System.out.println(
												"Enter the available copies");
										int aCopies = sc.nextInt();
										sc.nextLine();
										System.out.println(
												"Enter the category name");
										String catName = sc.nextLine();
										BookModel bModel = new BookModel(bid,
												bname, blang, bAuth, tCopies,
												aCopies);
										b = bService.isAddBook(bModel, catName);
										if (b) {
											System.out.println(
													"book added successfully.....");
										} else {
											System.out.println(
													"some error occur while adding books...");
										}
										break;

									case 2 :
										sc.nextLine();
										List<BookModel> bookList = bService
												.viewBooks();
										System.out.println("book id" + "\t\t"
												+ "book name" + "\t"
												+ "book languague" + "\t"
												+ "book author" + "\t"
												+ "total copies" + "\t"
												+ "available copies" + "\t"
												+ "category name");
										for (BookModel book : bookList) {
											System.out.println(book.getBid()
													+ "\t\t" + book.getBname()
													+ "\t\t" + book.getBlang()
													+ "\t\t" + book.getbAuth()
													+ "\t\t" + book.gettCopies()
													+ "\t\t" + book.getaCopies()
													+ "\t\t"
													+ book.getCat_name());
										}
										break;

									case 3 :
										sc.nextLine();
										System.out.println(
												"Enter the id and new name of book");
										int bookid = sc.nextInt();
										sc.nextLine();
										String bName = sc.nextLine();
										b = bService.isUpdateBookName(bookid,
												bName);
										if (b) {
											System.out.println(
													"book name updated successfully....");
										} else {
											System.out.println(
													"some error occur during updation of book name....");
										}
										break;

									case 4 :
										sc.nextLine();
										System.out.println(
												"Enter the name of the book you want to delete....");
										String bookName = sc.nextLine();
										b = bService.isDeleteBook(bookName);
										if (b) {
											System.out.println(
													"book deleted successfully....");
										} else {
											System.out.println(
													"error occur during deletion of book");
										}
										break;
								}
								break;

							case 4 : // add student
								System.out.println(
										"______________________________________________");
								System.out.println("1. Add Student");
								System.out.println("2. View Student");
								System.out.println("3. Update Student");
								System.out.println("4. Delete Student");
								System.out.println("Enter your choice");
								int choice4 = sc.nextInt();

								switch (choice4) {
									case 1 :
										System.out.println(
												"Enter the student id");
										int stid = sc.nextInt();
										sc.nextLine();
										System.out.println(
												"Enter the student name");
										String stname = sc.nextLine();
										System.out.println(
												"Enter the student contact");
										String stcontact = sc.nextLine();
										System.out.println(
												"Enter the student email");
										String stemail = sc.nextLine();
										System.out.println(
												"Enter the student year");
										String styear = sc.nextLine();
										System.out.println("set the username");
										String username = sc.nextLine();
										System.out.println("set the password");
										String password = sc.nextLine();
										StudentModel studModel = new StudentModel(
												stid, stname, stcontact,
												stemail, styear, username,
												password);
										b = studService.isAddStudent(studModel);
										if (b) {
											System.out.println(
													"Student added successfully...");
										} else {
											System.out.println(
													"some error is there...");
										}

										break;

									case 2 :
										List<StudentModel> lst = studService
												.viewStudentInfo();
										System.out.println("st_id" + "\t"
												+ "name" + "\t" + "contact"
												+ "\t\t" + "email" + "\t\t\t"
												+ "year" + "\t" + "username"
												+ "\t" + "password");
										for (StudentModel sm : lst) {
											System.out.println(sm.getStid()
													+ "\t" + sm.getStname()
													+ "\t" + sm.getStcontact()
													+ "\t" + sm.getStemail()
													+ "\t" + sm.getStyear()
													+ "\t" + sm.getUsername()
													+ "\t\t"
													+ sm.getPassword());
										}
										break;

									case 3 :
										System.out.println(
												"Enter the id and new name,contact,email,year,username and password of student");
										int id = sc.nextInt();
										sc.nextLine();
										String name = sc.nextLine();
										String contact = sc.nextLine();
										String email = sc.nextLine();
										String year = sc.nextLine();
										String userName = sc.nextLine();
										String passWord = sc.nextLine();
										b = studService.isUpdateStudentInfo(id,
												name, contact, email, year,
												userName, passWord);
										if (b) {
											System.out.println(
													"student data updated successfully...");
										} else {
											System.out.println(
													"error occur while updating student data....");
										}
										break;

									case 4 :
										System.out.println(
												"Enter the id you want to delete");
										int sid = sc.nextInt();
										b = studService.isDeleteStudent(sid);
										if (b) {
											System.out.println(
													"student deleted successfully....");
										} else {
											System.out.println(
													"some error occur during deletion of student...");
										}
										break;
								}
								break;

							case 5 : // issue books
								     // select i.iss_id,s.st_name,b.b_name,s.st_year,i.issue_date,i.due_date,i.status,i.return_date,i.fine from student s inner join issue_book i on s.st_id=i.st_id inner join books b on b.b_id=i.b_id
								     List<Issue_BookModel> lst3=isService.showIssueBookToAdmin();
								     System.out.println("Issue Id"+"\t"+"student Name"+"\t"+"Book Name"+"\t"+"Year"+"\t"+"Issue Date"+"\t"+"Due Date"+"\t"+"Status"+"\t"+"Return Date"+"\t"+"Fine");
								     for(Issue_BookModel is:lst3)
								     {
								    	 System.out.println(is.getIss_id()+"\t"+is.getSt_name()+"\t"+is.getBook_name()+"\t"+is.getSt_year()+"\t"+is.getIss_date()+"\t"+is.getDue_date()+"\t"+is.getStatus()+"\t"+is.getReturn_date()+"\t"+is.getFine());
								     }
								break;
                            
							case 6: //view category wise books
								    //select c.cat_name,b.b_name from category c inner join books b where c.cat_id=b.cat_id;
								    List<BookModel> lst1=bService.viewCatWiseBook();
								    System.out.println("Category"+"\t"+"Book Name");
								    for(BookModel book:lst1)
								    {
								    	System.out.println(book.getCat_name()+"\t\t"+book.getBname());
								    }
								    
								 break;
								 
							case 7://view book wise student count
								   //select b.b_name,count(i.st_id) from books b inner join issue_book i on b.b_id=i.b_id group by b.b_name;
								   List<BookModel> lst=bService.viewBookWiseStdCount();
								   System.out.println("Book Name"+"\t"+"Student Count");
								   for(BookModel book:lst)
								   {
									   System.out.println(book.getBname()+"\t"+book.getCount_stid());
								   }
								
								break;  
								
							case 8://student who not return book after due date
								   //select s.st_name,s.st_year,ib.issue_date,ib.due_date from student s inner join issue_book ib on s.st_id=ib.st_id where ib.status='borrowed'and ib.due_date<curdate();
								   List<Issue_BookModel> lst2=isService.viewStudentNotRetBook();
								   System.out.println("Student Name"+"\t"+"Year"+"\t"+"Issue Date"+"\t"+"Return Date");
								   for(Issue_BookModel ib:lst2)
								   {
									   System.out.println(ib.getSt_name()+"\t\t"+ib.getSt_year()+"\t"+ib.getIss_date()+"\t"+ib.getDue_date());
								   }
								
								break;
						}
					} while (choice1!=0);
				} else {
					System.out.println("Invalid Admin.....try again");
				}
				break;
			case 2 :
				sc.nextLine();
				System.out.println("Enter the username and password");
				String user1 = sc.nextLine();
				String pass1 = sc.nextLine();
				int st_id = studService.isValidStudent(user1, pass1);
				if (st_id>0) {
					System.out.println("Valid Student..");
					System.out.println("________________________________________________");
					do {
						System.out.println("______________________________________________");
						System.out.println("1. view my information");
						System.out.println("2. Issue books");
						System.out.println("3. Return books");
						System.out.println("4. Check status");
						System.out.println("Enter 0 to exit");
						System.out.println("Enter the choice");
						choice = sc.nextInt();
						switch (choice) {
							case 1 : // view my info
								List<StudentModel> sList = studService
										.showMyInfo(user1, pass1);
								
								System.out.println("st_id" + "\t" + "name"
										+ "\t" + "contact" + "\t\t" + "email"
										+ "\t\t\t" + "year" + "\t" + "username"
										+ "\t" + "password");

								for (StudentModel s : sList) {
									System.out.println(
											s.getStid() + "\t" + s.getStname()
													+ "\t" + s.getStcontact()
													+ "\t" + s.getStemail()
													+ "\t" + s.getStyear()
													+ "\t" + s.getUsername()
													+ "\t\t" + s.getPassword());
								}
								break;

							case 2 : // issue books
								sc.nextLine();
								System.out
										.println("do you want to issue books");
								String ans = sc.nextLine();
								String s1 = "yes";
								if (ans.equals(s1)) {
									List<BookModel> bookList = bService
											.viewBooks();
									System.out.println(
											"book id" + "\t\t" + "book name"
													+ "\t" + "book languague"
													+ "\t" + "book author"
													+ "\t" + "total copies"
													+ "\t" + "available copies"
													+ "\t" + "category name");
									for (BookModel book : bookList) {
										System.out.println(book.getBid()
												+ "\t\t" + book.getBname()
												+ "\t\t" + book.getBlang()
												+ "\t\t" + book.getbAuth()
												+ "\t\t" + book.gettCopies()
												+ "\t\t" + book.getaCopies()
												+ "\t\t" + book.getCat_name());
									}
//									sc.nextLine();
									System.out.println("Enter the book name");
									String bname=sc.nextLine();
									String status="borrowed";
									int book_id=isService.getBookIdByName(bname);
									System.out.println(book_id);
									String s=isService.getStatus(st_id, book_id);
									if(s.equals("borrowed"))
									{
										System.out.println("you already have borrowed this book..");
										System.out.println("you cannot borrowed another copy of same book...");
										
									}
									else
									{		
										if(book_id>0) 
	                                    {
	                                    	b=isService.issue_book(st_id,book_id,status);
	    									if(b)
	    									{
	    										System.out.println("Book issued successfully....");
	    									    b=isService.updateAvailableCopies(book_id);
	    									}
	    									else
	    									{
	    										System.out.println("Some error occur during book issue..");
	    									}
	                                    }
	                                    else
	                                    {
	                                    	System.out.println("Enter valid book name");
	                                    }
									}
									
								}
								else
								{
									System.out.println("Enter the correct word....");
								}
								break;
								
							case 3: //return book
								   sc.nextLine();
								   System.out.println("Do you want to return the book");
								   String s=sc.nextLine();
								   String ans1="yes";
								   if(s.equals(ans1))
								   {
									   List<BookModel> lst=bService.viewBorrowedBooks(st_id);
									   if(lst!=null)
									   {
										   System.out.println("List of Books you have borrowed");
										   for(BookModel book:lst)
										   {
											   System.out.println(book.getBname());
										   }
									   }
									   else
									   {
										   System.out.println("You have not borrowed any book...");
										   break;
									   }
									   System.out.println("Enter the book name you want to return");
									   String bname=sc.nextLine();
									   String status="returned";
									   int book_id=isService.getBookIdByName(bname);
									   b=isService.returnedBook(st_id, book_id, status);
									   if(b)
									   {
										   System.out.println("Returned successfully...");
										   b=isService.UpdateAvailableCopiesAfterReturn(book_id);
										   System.out.println("Kindly check your status");
									   }
									   else
									   {
										   System.out.println("some error is there");
									   }
									   
								   }
								    
								break;
								
							case 4: //check status
								List<Issue_BookModel> lst1=isService.showIssueBookDetails(st_id);
								System.out.println("Book Name"+"\t"+"Issue Date"+"\t"+"Due Date"+"\t"+"Status"+"\t"+"Return Date"+"\t"+"Fine");
								   for(Issue_BookModel iss:lst1)
								   {
									   System.out.println(iss.getBook_name()+"\t"+iss.getIss_date()+"\t"+iss.getDue_date()+"\t"+iss.getStatus()+"\t"+iss.getReturn_date()+"\t"+iss.getFine());
								   }
								break;								
						}
					} while (choice!=0);
				} else {
					System.out.println("Invalid student.....try again");
				}
				break;
		}
	}
}