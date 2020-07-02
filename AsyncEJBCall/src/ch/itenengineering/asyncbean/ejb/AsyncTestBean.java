package ch.itenengineering.asyncbean.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;

@Stateless
public class AsyncTestBean implements AsyncTestLocal {

	@Override
	public void saveMsgSync(String msg) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			Logger.getLogger(AsyncTestBean.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		System.out.println("AsyncTestBean.saveMsgSync " + msg);
	}

}
