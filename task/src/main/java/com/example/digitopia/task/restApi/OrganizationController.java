package com.example.digitopia.task.restApi;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.digitopia.task.Business.IOrganizationService;
import com.example.digitopia.task.Entities.Organization;
import com.example.digitopia.task.Entities.User;

@RestController
@RequestMapping("/api")
public class OrganizationController {
	private IOrganizationService organizationService;

	@Autowired
	public OrganizationController(IOrganizationService organizationService) {
		this.organizationService = organizationService;
	}
	
	@GetMapping("/orgs/{orgId}")
	public List<User> getAllUsers(@PathVariable int orgId){
		return organizationService.getAllUsers(orgId);
	}
	
	@PostMapping("/orgs/create")
	public void add(Organization org){
		organizationService.add(org);
	}
	
	@PostMapping("/orgs/update")
	public void update(Organization org){
		organizationService.update(org);
	}
	
	@PostMapping("/orgs/delete")
	public void delete(Organization org){
		organizationService.update(org);
	}
	
	@GetMapping("/orgs?name={organizationNormalizedName}&year={year}&size={companySize}")
	public List<Organization> getOrganizationByMetrics(@PathVariable String organizationNormalizedName, LocalDate year, int companySize ){
		return organizationService.getOrganizationsByMetric(organizationNormalizedName, year, companySize);
	}
	
	@GetMapping("/orgs?registerNumber={registerNumber}")
	public Organization getOrganizationByRegisterNumber(@PathVariable String registerNumber){
		return organizationService.getOrganizationByRegisterNumber(registerNumber);
	}
	
}
