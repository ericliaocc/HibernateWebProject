package tw.leonchen.action;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.leonchen.model.HouseBean;
import tw.leonchen.util.HibernateUtil;

public class DemoHouseBeanAction4 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Transaction Begin");
			
            Query<HouseBean> query = session.createQuery("from HouseBean", HouseBean.class);
            List<HouseBean> resultList = query.list();
            
            for(HouseBean hBean:resultList) {
            	System.out.println(hBean.getHouseid() + ":" + hBean.getHousename());
            }
            
            System.out.println("--------------------------------------------------------------");
            
            Iterator<HouseBean> i1 = resultList.iterator();
            while(i1.hasNext()) {
            	HouseBean resultBean = i1.next();
            	System.out.println(resultBean.getHouseid() + ":" + resultBean.getHousename());
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
