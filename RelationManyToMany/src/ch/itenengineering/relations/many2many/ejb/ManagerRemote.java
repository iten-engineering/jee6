package ch.itenengineering.relations.many2many.ejb;

import javax.ejb.Remote;

@Remote
public interface ManagerRemote {

	/**
	 * Löscht alle Einträge in den DB Tabellen.
	 */
	public void clear();

	/**
	 * Bucht fuer den Studenten mit der angegebenen Id den gewuenschten Kurs
	 * anhand der Kurs Id.
	 * 
	 * @param studentId
	 *            Primaerschluessel des Studenten der den Kurs buchen will.
	 * @param courseId
	 *            Primaerschluessel des zu buchenden Kurses.
	 */
	public void book(int studentId, int courseId);

	/**
	 * Annuliert einen gebuchten Kurs.
	 * 
	 * @param studentId
	 *            Primaerschluessel des Studenten der den Kurs annulieren will.
	 * @param courseId
	 *            Primaerschluessel des zu annulierenden Kurses.
	 */
	public void cancel(int studentId, int courseId);

	public Object persist(Object entity);

	public Object merge(Object entity);

	@SuppressWarnings("rawtypes")
	public Object find(Class clazz, Object primaryKey);

	@SuppressWarnings("rawtypes")
	public void remove(Class clazz, Object primaryKey);

} // end
