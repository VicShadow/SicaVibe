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

public class QuartoDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(QuartoDAO.class);
	public static Quarto loadQuartoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadQuartoByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("loadQuartoByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto getQuartoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getQuartoByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("getQuartoByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto loadQuartoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadQuartoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadQuartoByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto getQuartoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getQuartoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getQuartoByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto loadQuartoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Quarto) session.load(sicavibe.Quarto.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("loadQuartoByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto getQuartoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Quarto) session.get(sicavibe.Quarto.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("getQuartoByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto loadQuartoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Quarto) session.load(sicavibe.Quarto.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadQuartoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto getQuartoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Quarto) session.get(sicavibe.Quarto.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getQuartoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryQuarto(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryQuarto(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryQuarto(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryQuarto(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryQuarto(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryQuarto(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto[] listQuartoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listQuartoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listQuartoByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto[] listQuartoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listQuartoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listQuartoByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryQuarto(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Quarto as Quarto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listQuartoByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryQuarto(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Quarto as Quarto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Quarto", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listQuartoByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto[] listQuartoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryQuarto(session, condition, orderBy);
			return (Quarto[]) list.toArray(new Quarto[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listQuartoByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto[] listQuartoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryQuarto(session, condition, orderBy, lockMode);
			return (Quarto[]) list.toArray(new Quarto[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listQuartoByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto loadQuartoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadQuartoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadQuartoByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto loadQuartoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadQuartoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadQuartoByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto loadQuartoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Quarto[] quartos = listQuartoByQuery(session, condition, orderBy);
		if (quartos != null && quartos.length > 0)
			return quartos[0];
		else
			return null;
	}
	
	public static Quarto loadQuartoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Quarto[] quartos = listQuartoByQuery(session, condition, orderBy, lockMode);
		if (quartos != null && quartos.length > 0)
			return quartos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateQuartoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateQuartoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateQuartoByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateQuartoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateQuartoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateQuartoByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateQuartoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Quarto as Quarto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateQuartoByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateQuartoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Quarto as Quarto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Quarto", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateQuartoByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto createQuarto() {
		return new sicavibe.Quarto();
	}
	
	public static boolean save(sicavibe.Quarto quarto) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().saveObject(quarto);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(SicaVibe.Quarto quarto)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sicavibe.Quarto quarto) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().deleteObject(quarto);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(SicaVibe.Quarto quarto)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sicavibe.Quarto quarto) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().refresh(quarto);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(SicaVibe.Quarto quarto)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(sicavibe.Quarto quarto) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().evict(quarto);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(SicaVibe.Quarto quarto)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Quarto loadQuartoByCriteria(QuartoCriteria quartoCriteria) {
		Quarto[] quartos = listQuartoByCriteria(quartoCriteria);
		if(quartos == null || quartos.length == 0) {
			return null;
		}
		return quartos[0];
	}
	
	public static Quarto[] listQuartoByCriteria(QuartoCriteria quartoCriteria) {
		return quartoCriteria.listQuarto();
	}
}
