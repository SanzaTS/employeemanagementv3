package service;

import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.EmployeeEntity;

/**
 * Session Bean implementation class EmployeeEJB
 */
@Stateless
@LocalBean
public class EmployeeEJB {


	@PersistenceContext
	private EntityManager em;
	
    public EmployeeEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public void addNew(EmployeeEntity employeeEntity)
    {
    	System.out.println("============================");
    	System.out.println(employeeEntity.getName());
    	em.persist(employeeEntity);
    	System.out.println("============================");
    }
    
public List<EmployeeEntity> findEmployees(){
		
		

		em.getTransaction().begin();
		  List<EmployeeEntity> listEmployees = em.createQuery(
		            "SELECT p FROM Employee_tbl p").getResultList();
		Iterator it = listEmployees.iterator();
		while(it.hasNext()) {
			EmployeeEntity emp = (EmployeeEntity) it.next();
			System.out.print("Name"+emp.getName());
			System.out.print("Surname"+emp.getSurName());
			System.out.print("DOB"+emp.getDateOfBirth());
		}
		
		
		return listEmployees;
		
	}

}
