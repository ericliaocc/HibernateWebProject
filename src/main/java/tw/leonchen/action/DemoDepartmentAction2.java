package tw.leonchen.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import tw.leonchen.model.Department;
import tw.leonchen.util.HibernateUtil;

public class DemoDepartmentAction2 {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		Department dept =new Department();
		dept.setDeptname("HR");
		session.save(dept);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

}
