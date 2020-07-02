package ch.itenengineering.timer.ejb;

import javax.ejb.Stateless;

@Stateless
public class TimerBean implements TimerRemote {

	public void start(String name, long interval) {
	}

	public void stop(String name) {
	}

} // end of class
