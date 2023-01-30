package com.example.digitopia.task.Business;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.digitopia.task.DataAccess.IOrganizationDal;
import com.example.digitopia.task.Entities.Organization;
import com.example.digitopia.task.Entities.User;

@Service
public class OrganizationManager implements IOrganizationService {
	
	private IOrganizationDal organizationDal;

	@Autowired
	public OrganizationManager(IOrganizationDal organizationDal) {
		this.organizationDal = organizationDal;
	}
	
	@Override
	public List<User> getAllUsers(int userId) {
		
		return organizationDal.getAllUsers(userId);
	}

	

	@Override
	public void add(Organization organization) {
		organizationDal.add(organization);
	}

	@Override
	public void update(Organization organization) {
		organizationDal.update(organization);
		
	}

	@Override
	public void delete(Organization organization) {
		organizationDal.delete(organization);
		
	}

	@Override
	public List<Organization> getOrganizationsByMetric(String organizationNormalizedName, LocalDate year,
			int companySize) {
		return organizationDal.getOrganizationsByMetric(organizationNormalizedName, year, companySize);
	}

	@Override
	public Organization getOrganizationByRegisterNumber(String registerNumber) {
		return organizationDal.getOrganizationByRegisterNumber(registerNumber);
	}

}
