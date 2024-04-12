package org_library_service;

import org_library_model.AdminModel;
import org_library_repository.AdminRepository;

public class AdminService {
  AdminRepository aRepo=new AdminRepository();
  public boolean verifyAdmin(AdminModel aModel)
  {
	  return aRepo.verifyAdmin(aModel)?true:false;
  }
}