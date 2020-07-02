package ch.itenengineering.env.ejb;

import javax.ejb.Stateless;

@Stateless
public class EnvBean implements EnvRemote {

	private String messageA;

	private String messageB;

	public String getMessages() {
		return "TODO";
	}

} // end
