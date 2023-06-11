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

public class TipoDeQuartoDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(TipoDeQuartoDAO.class);
	public static TipoDeQuarto loadTipoDeQuartoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadTipoDeQuartoByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("loadTipoDeQuartoByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto getTipoDeQuartoByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getTipoDeQuartoByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("getTipoDeQuartoByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto loadTipoDeQuartoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadTipoDeQuartoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadTipoDeQuartoByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto getTipoDeQuartoByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getTipoDeQuartoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getTipoDeQuartoByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto loadTipoDeQuartoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (TipoDeQuarto) session.load(sicavibe.TipoDeQuarto.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("loadTipoDeQuartoByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto getTipoDeQuartoByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (TipoDeQuarto) session.get(sicavibe.TipoDeQuarto.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("getTipoDeQuartoByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto loadTipoDeQuartoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (TipoDeQuarto) session.load(sicavibe.TipoDeQuarto.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadTipoDeQuartoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto getTipoDeQuartoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (TipoDeQuarto) session.get(sicavibe.TipoDeQuarto.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getTipoDeQuartoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryTipoDeQuarto(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryTipoDeQuarto(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryTipoDeQuarto(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryTipoDeQuarto(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryTipoDeQuarto(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryTipoDeQuarto(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto[] listTipoDeQuartoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listTipoDeQuartoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listTipoDeQuartoByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto[] listTipoDeQuartoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listTipoDeQuartoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listTipoDeQuartoByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryTipoDeQuarto(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.TipoDeQuarto as TipoDeQuarto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listTipoDeQuartoByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryTipoDeQuarto(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.TipoDeQuarto as TipoDeQuarto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TipoDeQuarto", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listTipoDeQuartoByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto[] listTipoDeQuartoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTipoDeQuarto(session, condition, orderBy);
			return (TipoDeQuarto[]) list.toArray(new TipoDeQuarto[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listTipoDeQuartoByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto[] listTipoDeQuartoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTipoDeQuarto(session, condition, orderBy, lockMode);
			return (TipoDeQuarto[]) list.toArray(new TipoDeQuarto[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listTipoDeQuartoByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto loadTipoDeQuartoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadTipoDeQuartoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadTipoDeQuartoByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto loadTipoDeQuartoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadTipoDeQuartoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadTipoDeQuartoByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto loadTipoDeQuartoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		TipoDeQuarto[] tipoDeQuartos = listTipoDeQuartoByQuery(session, condition, orderBy);
		if (tipoDeQuartos != null && tipoDeQuartos.length > 0)
			return tipoDeQuartos[0];
		else
			return null;
	}
	
	public static TipoDeQuarto loadTipoDeQuartoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		TipoDeQuarto[] tipoDeQuartos = listTipoDeQuartoByQuery(session, condition, orderBy, lockMode);
		if (tipoDeQuartos != null && tipoDeQuartos.length > 0)
			return tipoDeQuartos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTipoDeQuartoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateTipoDeQuartoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateTipoDeQuartoByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTipoDeQuartoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateTipoDeQuartoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateTipoDeQuartoByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTipoDeQuartoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.TipoDeQuarto as TipoDeQuarto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateTipoDeQuartoByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTipoDeQuartoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.TipoDeQuarto as TipoDeQuarto");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TipoDeQuarto", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateTipoDeQuartoByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto createTipoDeQuarto() {
		return new sicavibe.TipoDeQuarto();
	}
	
	public static boolean save(sicavibe.TipoDeQuarto tipoDeQuarto) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().saveObject(tipoDeQuarto);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(SicaVibe.TipoDeQuarto tipoDeQuarto)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sicavibe.TipoDeQuarto tipoDeQuarto) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().deleteObject(tipoDeQuarto);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(SicaVibe.TipoDeQuarto tipoDeQuarto)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sicavibe.TipoDeQuarto tipoDeQuarto) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().refresh(tipoDeQuarto);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(SicaVibe.TipoDeQuarto tipoDeQuarto)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(sicavibe.TipoDeQuarto tipoDeQuarto) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().evict(tipoDeQuarto);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(SicaVibe.TipoDeQuarto tipoDeQuarto)", e);
			throw new PersistentException(e);
		}
	}
	
	public static TipoDeQuarto loadTipoDeQuartoByCriteria(TipoDeQuartoCriteria tipoDeQuartoCriteria) {
		TipoDeQuarto[] tipoDeQuartos = listTipoDeQuartoByCriteria(tipoDeQuartoCriteria);
		if(tipoDeQuartos == null || tipoDeQuartos.length == 0) {
			return null;
		}
		return tipoDeQuartos[0];
	}
	
	public static TipoDeQuarto[] listTipoDeQuartoByCriteria(TipoDeQuartoCriteria tipoDeQuartoCriteria) {
		return tipoDeQuartoCriteria.listTipoDeQuarto();
	}
}
