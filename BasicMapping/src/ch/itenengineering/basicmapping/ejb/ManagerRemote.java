package ch.itenengineering.basicmapping.ejb;

import javax.ejb.Remote;

@Remote
public interface ManagerRemote {

	public Object persist(Object entity);

	public Object merge(Object entity);

	@SuppressWarnings("rawtypes")
	public Object find(Class clazz, Object primaryKey);

	@SuppressWarnings("rawtypes")
	public void remove(Class clazz, Object primaryKey);

} // end
