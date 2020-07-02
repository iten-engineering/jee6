package ch.itenengineering.jms.p2p;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.NamingException;

//TODO MessageListner Interface implementieren
public class Receiver {

	//
	// fields
	//
	Connection connection;

	Session session;

	Queue queue;

	MessageConsumer messageConsumer;

	// ---------------------------------------------------------------------
	// methods
	// ---------------------------------------------------------------------

	public void start() throws NamingException, JMSException {

		Context ctx = Sender.getInitialContext();

		// TODO
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

		Receiver receiver = new Receiver();

		try {

			receiver.start();

			System.out
					.println("receiver starts listening (press <RETURN> to stop)...");
			(new BufferedReader(new InputStreamReader(System.in))).readLine();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			receiver.stop();
			System.out.println("receiver stopped!");
		}
		System.exit(0);
	}

} // end of class
