package ch.itenengineering.bookshop.client;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.itenengineering.bookshop.domain.Item;
import ch.itenengineering.bookshop.ejb.BasketRemote;

public class BookshopClient {

	public static Context getInitialContext() throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();

		env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		return new InitialContext(env);
	}

	public void testOrder() throws Exception {

		// init
		Context ctx = getInitialContext();
		BasketRemote basketA = (BasketRemote) ctx
				.lookup("ejb:/Bookshop/BasketBean!ch.itenengineering.bookshop.ejb.BasketRemote?stateful");
		BasketRemote basketB = (BasketRemote) ctx
				.lookup("ejb:/Bookshop/BasketBean!ch.itenengineering.bookshop.ejb.BasketRemote?stateful");

		// add items

		// show items

		// close baskets

	}

	private void printBasket(Map<String, Item> basket) {
		for (Iterator<String> iter = basket.keySet().iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			Item item = basket.get(key);

			System.out.println("  " + item.toString());
		}
	}

	public static void main(String[] args) {

		try {
			// run the application
			new BookshopClient().testOrder();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

} // end of class

