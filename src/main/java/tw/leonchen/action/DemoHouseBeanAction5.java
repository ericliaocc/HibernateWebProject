package tw.leonchen.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.leonchen.model.HouseBean;
import tw.leonchen.util.HibernateUtil;

public class DemoHouseBeanAction5 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Transaction Begin");

			HouseBean deleteBean = new HouseBean();
			deleteBean.setHouseid(1003);
			deleteBean.setHousename("Nice House");
			
			session.delete(deleteBean);
			
			session.getTransaction().commit();
			System.out.println("Transaction Commit");
		}catch(Exception e) {
			session.getTransaction().rollback();
			System.out.println("Transaction RollBack");
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}
