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

public class ServicoExtraDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(ServicoExtraDAO.class);
	public static ServicoExtra loadServicoExtraByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadServicoExtraByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("loadServicoExtraByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra getServicoExtraByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getServicoExtraByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("getServicoExtraByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra loadServicoExtraByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadServicoExtraByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadServicoExtraByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra getServicoExtraByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getServicoExtraByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getServicoExtraByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra loadServicoExtraByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ServicoExtra) session.load(sicavibe.ServicoExtra.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("loadServicoExtraByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra getServicoExtraByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (ServicoExtra) session.get(sicavibe.ServicoExtra.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("getServicoExtraByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra loadServicoExtraByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ServicoExtra) session.load(sicavibe.ServicoExtra.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadServicoExtraByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra getServicoExtraByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ServicoExtra) session.get(sicavibe.ServicoExtra.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getServicoExtraByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryServicoExtra(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryServicoExtra(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryServicoExtra(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryServicoExtra(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryServicoExtra(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryServicoExtra(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra[] listServicoExtraByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listServicoExtraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listServicoExtraByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra[] listServicoExtraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listServicoExtraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listServicoExtraByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryServicoExtra(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.ServicoExtra as ServicoExtra");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listServicoExtraByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryServicoExtra(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.ServicoExtra as ServicoExtra");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ServicoExtra", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listServicoExtraByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra[] listServicoExtraByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryServicoExtra(session, condition, orderBy);
			return (ServicoExtra[]) list.toArray(new ServicoExtra[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listServicoExtraByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra[] listServicoExtraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryServicoExtra(session, condition, orderBy, lockMode);
			return (ServicoExtra[]) list.toArray(new ServicoExtra[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listServicoExtraByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra loadServicoExtraByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadServicoExtraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadServicoExtraByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra loadServicoExtraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadServicoExtraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadServicoExtraByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra loadServicoExtraByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ServicoExtra[] servicoExtras = listServicoExtraByQuery(session, condition, orderBy);
		if (servicoExtras != null && servicoExtras.length > 0)
			return servicoExtras[0];
		else
			return null;
	}
	
	public static ServicoExtra loadServicoExtraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ServicoExtra[] servicoExtras = listServicoExtraByQuery(session, condition, orderBy, lockMode);
		if (servicoExtras != null && servicoExtras.length > 0)
			return servicoExtras[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateServicoExtraByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateServicoExtraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateServicoExtraByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateServicoExtraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateServicoExtraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateServicoExtraByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateServicoExtraByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.ServicoExtra as ServicoExtra");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateServicoExtraByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateServicoExtraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.ServicoExtra as ServicoExtra");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ServicoExtra", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateServicoExtraByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra createServicoExtra() {
		return new sicavibe.ServicoExtra();
	}
	
	public static boolean save(sicavibe.ServicoExtra servicoExtra) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().saveObject(servicoExtra);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(SicaVibe.ServicoExtra servicoExtra)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sicavibe.ServicoExtra servicoExtra) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().deleteObject(servicoExtra);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(SicaVibe.ServicoExtra servicoExtra)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sicavibe.ServicoExtra servicoExtra) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().refresh(servicoExtra);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(SicaVibe.ServicoExtra servicoExtra)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(sicavibe.ServicoExtra servicoExtra) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().evict(servicoExtra);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(SicaVibe.ServicoExtra servicoExtra)", e);
			throw new PersistentException(e);
		}
	}
	
	public static ServicoExtra loadServicoExtraByCriteria(ServicoExtraCriteria servicoExtraCriteria) {
		ServicoExtra[] servicoExtras = listServicoExtraByCriteria(servicoExtraCriteria);
		if(servicoExtras == null || servicoExtras.length == 0) {
			return null;
		}
		return servicoExtras[0];
	}
	
	public static ServicoExtra[] listServicoExtraByCriteria(ServicoExtraCriteria servicoExtraCriteria) {
		return servicoExtraCriteria.listServicoExtra();
	}
}
