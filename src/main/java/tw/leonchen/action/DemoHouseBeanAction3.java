package tw.leonchen.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.leonchen.model.HouseBean;
import tw.leonchen.util.HibernateUtil;

public class DemoHouseBeanAction3 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Transaction Begin");
			
			HouseBean resultBean2 = session.get(HouseBean.class, 1003);
			
			if(resultBean2!=null) {
			    System.out.println(resultBean2.getHouseid() + ":" + resultBean2.getHousename());
			}else {
				System.out.println("no result");
			}
			
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
