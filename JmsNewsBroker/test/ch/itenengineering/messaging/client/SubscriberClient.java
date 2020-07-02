package ch.itenengineering.messaging.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.NamingException;

public class SubscriberClient implements javax.jms.MessageListener {

	//
	// const
	//
	public static final String JNDI_NAME_CONNECTION_FACTORY = AgencyClient.JNDI_NAME_CONNECTION_FACTORY;

	public static final String JNDI_NAME_TOPIC = "jms/topic/newsTopic";

	//
	// fields
	//
	Topic topic;

	Connection connection;

	Session session;

	MessageConsumer messageConsumer;

	// ---------------------------------------------------------------------
	// methods
	// ---------------------------------------------------------------------

	/**
	 * Listen to the news topic for the given message selector.
	 * <p>
	 * Note:<br />
	 * The message selector is a String whose syntax is based on a subset of the
	 * SQL92 conditional expression syntax. For further details and samples see
	 * the javax.jmx.Message Javadoc.
	 * </p>
	 * 
	 * @param messageSelector
	 *            filter only desired agency or all (messsageSelector=null)
	 * @throws NamingException
	 */
	public void start(String messageSelector) throws NamingException,
			JMSException {

		Context ctx = AgencyClient.getInitialContext();

		// TODO
		// init jms and start listening
	}

	/**
	 * @see javax.jms.MessageListener()
	 */
	public void onMessage(Message message) {
		try {

			// TODO
			// receive message and print them to system out

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

		SubscriberClient subscriber = new SubscriberClient();

		try {

			subscriber.start(null);

			System.out
					.println("subscriber starts listening (press <RETURN> to stop)...");
			(new BufferedReader(new InputStreamReader(System.in))).readLine();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			subscriber.stop();
			System.out.println("subscriber stopped!");
		}

		System.exit(0);
	}

} // end of class

