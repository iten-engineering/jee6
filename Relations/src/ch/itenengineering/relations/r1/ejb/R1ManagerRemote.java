package ch.itenengineering.relations.r1.ejb;

import javax.ejb.Remote;

@Remote
public interface R1ManagerRemote {

	public Object persist(Object entity);

	public Object merge(Object entity);

	public Object find(Class clazz, Object primaryKey);

	public void remove(Class clazz, Object primaryKey);

} // end
