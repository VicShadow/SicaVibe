/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: vicshadow(Universidade do Minho)
 * License Type: Academic
 */
package sicavibe;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class AdministadorDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(AdministadorDAO.class);
	public static Administador loadAdministadorByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadAdministadorByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("loadAdministadorByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador getAdministadorByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getAdministadorByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("getAdministadorByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador loadAdministadorByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadAdministadorByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadAdministadorByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador getAdministadorByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getAdministadorByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getAdministadorByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador loadAdministadorByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Administador) session.load(sicavibe.Administador.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("loadAdministadorByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador getAdministadorByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Administador) session.get(sicavibe.Administador.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("getAdministadorByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador loadAdministadorByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Administador) session.load(sicavibe.Administador.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadAdministadorByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador getAdministadorByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Administador) session.get(sicavibe.Administador.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getAdministadorByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryAdministador(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryAdministador(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryAdministador(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryAdministador(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryAdministador(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryAdministador(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador[] listAdministadorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listAdministadorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listAdministadorByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador[] listAdministadorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listAdministadorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listAdministadorByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryAdministador(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Administador as Administador");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listAdministadorByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryAdministador(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Administador as Administador");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Administador", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listAdministadorByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador[] listAdministadorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAdministador(session, condition, orderBy);
			return (Administador[]) list.toArray(new Administador[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listAdministadorByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador[] listAdministadorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAdministador(session, condition, orderBy, lockMode);
			return (Administador[]) list.toArray(new Administador[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listAdministadorByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador loadAdministadorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadAdministadorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadAdministadorByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador loadAdministadorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadAdministadorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadAdministadorByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador loadAdministadorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Administador[] administadors = listAdministadorByQuery(session, condition, orderBy);
		if (administadors != null && administadors.length > 0)
			return administadors[0];
		else
			return null;
	}
	
	public static Administador loadAdministadorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Administador[] administadors = listAdministadorByQuery(session, condition, orderBy, lockMode);
		if (administadors != null && administadors.length > 0)
			return administadors[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAdministadorByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateAdministadorByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateAdministadorByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAdministadorByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateAdministadorByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateAdministadorByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAdministadorByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Administador as Administador");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateAdministadorByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAdministadorByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Administador as Administador");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Administador", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateAdministadorByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador createAdministador() {
		return new sicavibe.Administador();
	}
	
	public static boolean save(sicavibe.Administador administador) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().saveObject(administador);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(SicaVibe.Administador administador)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sicavibe.Administador administador) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().deleteObject(administador);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(SicaVibe.Administador administador)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sicavibe.Administador administador) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			session.update(administador);
			session.flush();
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(SicaVibe.Administador administador)", e);
			throw new PersistentException(e);
		}
	}

	
	public static boolean evict(sicavibe.Administador administador) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().evict(administador);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(SicaVibe.Administador administador)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Administador loadAdministadorByCriteria(AdministadorCriteria administadorCriteria) {
		Administador[] administadors = listAdministadorByCriteria(administadorCriteria);
		if(administadors == null || administadors.length == 0) {
			return null;
		}
		return administadors[0];
	}
	
	public static Administador[] listAdministadorByCriteria(AdministadorCriteria administadorCriteria) {
		return administadorCriteria.listAdministador();
	}
}
