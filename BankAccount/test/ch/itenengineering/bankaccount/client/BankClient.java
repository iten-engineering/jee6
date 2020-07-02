package ch.itenengineering.bankaccount.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BankClient {

	public static Context getInitialContext() throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();

		env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		return new InitialContext(env);
	}

	public void testAccount() throws Exception {

		// init
		Context ctx = getInitialContext();

		// TODO

	}

	public static void main(String[] args) {

		try {
			// run the application
			new BankClient().testAccount();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

} // end of class
