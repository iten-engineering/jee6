package ch.itenengineering.transactiontest.client;

import static org.junit.Assert.assertTrue;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import ch.itenengineering.transactiontest.ejb.AppException;
import ch.itenengineering.transactiontest.ejb.TransactionTestRemote;

public class TransactionUnitTest {

	TransactionTestRemote remote;

	public static Context getInitialContext() throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();

		env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		return new InitialContext(env);
	}

	@Before
	public void setUp() throws Exception {
		Context ctx = getInitialContext();
		remote = (TransactionTestRemote) ctx
				.lookup("ejb:/TransactionTest/TransactionTestBean!ch.itenengineering.transactiontest.ejb.TransactionTestRemote?stateful");
	}

	/**
	 * expect commit (check table transaction_test for an entry)
	 */
	@Test
	public void testAppException() {
		try {
			remote.testAppException();
			assertTrue(false);
		} catch (AppException ae) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
		try {
			remote.isBeanAlive();
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

} // end test
