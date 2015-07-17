package repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

public class BaseRepository {

	public static void save(Object obj1, Object obj2) {
		TransactionManager tm = com.arjuna.ats.jta.TransactionManager
				.transactionManager();
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("MyPersistence");
		EntityManager em = emf.createEntityManager();
		try {
			tm.begin();
			em.joinTransaction();
			em.persist(obj1);
			em.persist(obj2);

			tm.commit();
			em.clear();
		} catch (Exception exp) {
			try {
				tm.rollback();
			} catch (IllegalStateException | SecurityException
					| SystemException e) {
				e.printStackTrace();
			}
			em.clear();
		} finally {
			em.close();
			emf.close();
		}
	}
}
