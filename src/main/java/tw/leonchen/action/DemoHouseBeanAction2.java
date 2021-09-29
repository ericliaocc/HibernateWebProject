package tw.leonchen.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.leonchen.model.HouseBean;
import tw.leonchen.util.HibernateUtil;

public class DemoHouseBeanAction2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Transaction Begin");
			
			//CRUD Action
			HouseBean hBean2 = new HouseBean();
			hBean2.setHouseid(1003);
			hBean2.setHousename("Beautiful House");
			session.save(hBean2);
			
			HouseBean resultBean = session.load(HouseBean.class, 1003);
			System.out.println(resultBean.getHouseid() + ":" + resultBean.getHousename());
			
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
