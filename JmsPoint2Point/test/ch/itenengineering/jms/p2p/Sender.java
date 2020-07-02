package ch.itenengineering.jms.p2p;

import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Sender {

	//
	// const
	//
	public static final String JNDI_NAME_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";

	public static final String JNDI_NAME_QUEUE = "jms/queue/p2pQueue";

	//
	// fields
	//
	Connection connection;

	Session session;

	Queue queue;

	MessageProducer messageProducer;

	// ---------------------------------------------------------------------
	// methods
	// ---------------------------------------------------------------------

	public static Context getInitialContext() throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();

		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jboss.naming.remote.client.InitialContextFactory");

		env.put(Context.PROVIDER_URL, "remote://localhost:4447");

		env.put(Context.SECURITY_PRINCIPAL,
				System.getProperty("username", "guest"));

		env.put(Context.SECURITY_CREDENTIALS,
				System.getProperty("password", "1234"));

		return new InitialContext(env);
	}

	/**
	 * Initialize the jms message producer
	 * 
	 * @throws NamingException
	 * @throws JMSException
	 */
	public void start() throws NamingException, JMSException {

		Context ctx = getInitialContext();

		// TODO
	}

	public void send(String message) throws NamingException, JMSException {

		// TODO
	}

	/**
	 * Since a provider typically allocates significant resources outside the
	 * JVM on behalf of a connection, clients should close these resources when
	 * they are not needed. Relying on garbage collection to eventually reclaim
	 * these resources may not be timely enough.
	 * 
	 * There is no need to close the sessions, producers, and consumers of a
	 * closed connection.
	 */
	public void stop() {
		try {
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			// ignore
		}
	}

	// ---------------------------------------------------------------------
	// main
	// ---------------------------------------------------------------------

	public static void main(String[] args) {

		Sender sender = new Sender();

		try {

			// TODO

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sender.stop();
		}

		System.exit(0);
	}

} // end of class
