package ch.itenengineering.transactiontest.ejb;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.itenengineering.transactiontest.domain.TransactionTest;

@Stateful
public class TransactionTestBean implements TransactionTestRemote {

	@PersistenceContext(unitName = "TransactionTestPU")
	private EntityManager em;

	public boolean isBeanAlive() {
		return true;
	}

	public void testAppException() throws Exception {
		em.persist(new TransactionTest("testAppException, commit expected"));
		throw new AppException();
	}

} // end of class
