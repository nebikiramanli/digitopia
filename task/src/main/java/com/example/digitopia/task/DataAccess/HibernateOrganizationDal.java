package com.example.digitopia.task.DataAccess;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.digitopia.task.Entities.Organization;
import com.example.digitopia.task.Entities.User;

@Repository
public class HibernateOrganizationDal implements IOrganizationDal {
	
	private EntityManager entityManager;

	@Autowired
	public HibernateOrganizationDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public List<Organization> getOrganizationsByMetric(String organizationNormalizedName, LocalDate year, int companySize) {
		Session session = entityManager.unwrap(Session.class);
		String query = "from organization Where normalized_name LIKE '%"+ organizationNormalizedName +"%' OR year LIKE '%"+ year +"%' OR company_size LIKE '%"+ companySize+"%'";
		List<Organization> organizations = session.createQuery(query, Organization.class).getResultList();
		return organizations;
	}

	@Override
	@Transactional
	public Organization getOrganizationByRegisterNumber(String registerNumber) {
		Session session = entityManager.unwrap(Session.class);
		String query = "from organization Where register_number = '"+ registerNumber +"'";
		Organization organization = session.createQuery(query, Organization.class).getSingleResult();
		return organization;
	}



	@Override
	@Transactional
	public List<User> getAllUsers(int orgId) {
		Session session = entityManager.unwrap(Session.class);
		String query = String.format("from user Where org_id = '%s'", orgId);
		List<User> users = session.createQuery(query, User.class).getResultList();
		return users;
	}



	@Override
	@Transactional
	public void add(Organization organization) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(organization);
		
	}



	@Override
	@Transactional
	public void update(Organization organization) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(organization);
		
	}


	@Override
	@Transactional
	public void delete(Organization organization) {
		Session session = entityManager.unwrap(Session.class);
		session.delete(organization);
		
	}

}
