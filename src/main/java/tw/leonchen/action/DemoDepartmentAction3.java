package tw.leonchen.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.leonchen.model.Department;
import tw.leonchen.util.HibernateUtil;

public class DemoDepartmentAction3 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//...CRUD Action
			Department dept3 = new Department();
			dept3.setDeptname("Sales");
			Serializable resultDept = session.save(dept3);
			System.out.println("resultDept:" + resultDept);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
