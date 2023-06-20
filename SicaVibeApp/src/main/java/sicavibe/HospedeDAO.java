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

public class HospedeDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(HospedeDAO.class);
	public static Hospede loadHospedeByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadHospedeByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("loadHospedeByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede getHospedeByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getHospedeByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("getHospedeByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede loadHospedeByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadHospedeByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadHospedeByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede getHospedeByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getHospedeByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getHospedeByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede loadHospedeByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Hospede) session.load(sicavibe.Hospede.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("loadHospedeByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede getHospedeByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Hospede) session.get(sicavibe.Hospede.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("getHospedeByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede loadHospedeByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Hospede) session.load(sicavibe.Hospede.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadHospedeByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede getHospedeByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Hospede) session.get(sicavibe.Hospede.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getHospedeByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryHospede(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryHospede(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryHospede(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryHospede(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryHospede(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryHospede(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede[] listHospedeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listHospedeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listHospedeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede[] listHospedeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listHospedeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listHospedeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryHospede(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Hospede as Hospede");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listHospedeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryHospede(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Hospede as Hospede");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Hospede", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listHospedeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede[] listHospedeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryHospede(session, condition, orderBy);
			return (Hospede[]) list.toArray(new Hospede[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listHospedeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede[] listHospedeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryHospede(session, condition, orderBy, lockMode);
			return (Hospede[]) list.toArray(new Hospede[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listHospedeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede loadHospedeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadHospedeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadHospedeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede loadHospedeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadHospedeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadHospedeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede loadHospedeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Hospede[] hospedes = listHospedeByQuery(session, condition, orderBy);
		if (hospedes != null && hospedes.length > 0)
			return hospedes[0];
		else
			return null;
	}
	
	public static Hospede loadHospedeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Hospede[] hospedes = listHospedeByQuery(session, condition, orderBy, lockMode);
		if (hospedes != null && hospedes.length > 0)
			return hospedes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateHospedeByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateHospedeByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateHospedeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHospedeByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateHospedeByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateHospedeByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHospedeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Hospede as Hospede");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateHospedeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHospedeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Hospede as Hospede");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Hospede", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateHospedeByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede createHospede() {
		return new sicavibe.Hospede();
	}

	public static boolean save(sicavibe.Hospede hospede) throws PersistentException {
		try {
			PersistentManager vp = sicavibe.SicaVibeMainVPPersistentManager.instance();
			try {
				vp.saveObject(hospede);
			}
			catch (Exception e) {
				vp.getSession().getTransaction().rollback();
				throw new PersistentException(e);
			}
			return true;
		}
		catch (Exception e) {
			_logger.error("save(SicaVibe.Hospede hospede)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sicavibe.Hospede hospede) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().deleteObject(hospede);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(SicaVibe.Hospede hospede)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sicavibe.Hospede hospede) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().refresh(hospede);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(SicaVibe.Hospede hospede)", e);
			throw new PersistentException(e);
		}
	}

	
	public static boolean evict(sicavibe.Hospede hospede) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().evict(hospede);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(SicaVibe.Hospede hospede)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hospede loadHospedeByCriteria(HospedeCriteria hospedeCriteria) {
		Hospede[] hospedes = listHospedeByCriteria(hospedeCriteria);
		if(hospedes == null || hospedes.length == 0) {
			return null;
		}
		return hospedes[0];
	}
	
	public static Hospede[] listHospedeByCriteria(HospedeCriteria hospedeCriteria) {
		return hospedeCriteria.listHospede();
	}
}
