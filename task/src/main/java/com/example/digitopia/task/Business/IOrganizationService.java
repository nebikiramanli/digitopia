package com.example.digitopia.task.Business;

import java.time.LocalDate;
import java.util.List;

import com.example.digitopia.task.Entities.Organization;
import com.example.digitopia.task.Entities.User;

public interface IOrganizationService {
	List<User> getAllUsers(int userId);
	void add(Organization organization);
	void update (Organization organization);
	void delete (Organization organization);
	List<Organization> getOrganizationsByMetric(String organizationNormalizedName, LocalDate year, int companySize);
	Organization getOrganizationByRegisterNumber(String registerNumber);
	
}
