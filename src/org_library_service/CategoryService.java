package org_library_service;
import java.util.*;
import org_library_model.CategoryModel;
import org_library_repository.CategoryRepository;

public class CategoryService {
	CategoryRepository catRepo=new CategoryRepository();
    public boolean addCategory(CategoryModel catModel,String shelfName)
    {	
	 return catRepo.addCategory(catModel,shelfName)?true:false; 
    }
    public List<CategoryModel> viewCategory()
    {
    	return catRepo.viewCategory();
    }
    public boolean updateCategory(int catId,String catName)
    {
    	return catRepo.updateCategory(catId,catName)?true:false;
    }
    public boolean deleteCategory(String catname)
    {
    	return catRepo.deleteCategory(catname)?true:false;
    }
}