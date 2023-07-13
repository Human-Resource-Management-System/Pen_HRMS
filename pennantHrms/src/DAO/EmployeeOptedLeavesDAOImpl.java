package DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import DAO_Interfaces.EmployeeOptedLeavesDAO;
import models.EmployeeOptedLeaves;

@Transactional
public class EmployeeOptedLeavesDAOImpl implements EmployeeOptedLeavesDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveEmployeeOptedLeaves(EmployeeOptedLeaves employeeoptedleaves) {
		entityManager.persist(employeeoptedleaves);
	}
}
