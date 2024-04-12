package org_library_service;
import java.util.*;
import org_library_model.ShelfModel;
import org_library_repository.ShelfRepository;

public class ShelfService {
	ShelfRepository shRepo=new ShelfRepository();
	public boolean setShelf(ShelfModel shModel)
	{
		return shRepo.setShelf(shModel)?true:false;
	}
    public List<ShelfModel> viewShelf()
    {
    	return shRepo.ViewShelf();
    }
    public boolean isUpdateShelf(int sheid,String sheName)
    {
    	return shRepo.isUpdateShelf(sheid, sheName)?true:false;
    }
	public boolean deleteShelfName(String shelfName)
	{	
		return shRepo.deleteShelfName(shelfName)?true:false;
	}
}