package tw.leonchen.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.leonchen.model.Department;
import tw.leonchen.util.HibernateUtil;

public class DemoDepartmentAction4 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//...CRUD Action
			Department dept4 = new Department();
			dept4.setDeptname("QA");
			session.persist(dept4);
			session.flush();
			
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
