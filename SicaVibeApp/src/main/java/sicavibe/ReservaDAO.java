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

public class ReservaDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(ReservaDAO.class);
	public static Reserva loadReservaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadReservaByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("loadReservaByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva getReservaByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getReservaByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("getReservaByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva loadReservaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadReservaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadReservaByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva getReservaByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getReservaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getReservaByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva loadReservaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Reserva) session.load(sicavibe.Reserva.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("loadReservaByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva getReservaByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Reserva) session.get(sicavibe.Reserva.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("getReservaByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva loadReservaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Reserva) session.load(sicavibe.Reserva.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadReservaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva getReservaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Reserva) session.get(sicavibe.Reserva.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getReservaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryReserva(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryReserva(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryReserva(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryReserva(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryReserva(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryReserva(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva[] listReservaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listReservaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listReservaByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva[] listReservaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listReservaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listReservaByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryReserva(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Reserva as Reserva");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listReservaByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryReserva(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Reserva as Reserva");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Reserva", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listReservaByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva[] listReservaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryReserva(session, condition, orderBy);
			return (Reserva[]) list.toArray(new Reserva[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listReservaByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva[] listReservaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryReserva(session, condition, orderBy, lockMode);
			return (Reserva[]) list.toArray(new Reserva[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listReservaByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva loadReservaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadReservaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadReservaByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva loadReservaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadReservaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadReservaByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva loadReservaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Reserva[] reservas = listReservaByQuery(session, condition, orderBy);
		if (reservas != null && reservas.length > 0)
			return reservas[0];
		else
			return null;
	}
	
	public static Reserva loadReservaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Reserva[] reservas = listReservaByQuery(session, condition, orderBy, lockMode);
		if (reservas != null && reservas.length > 0)
			return reservas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateReservaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateReservaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateReservaByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReservaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateReservaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateReservaByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReservaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Reserva as Reserva");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateReservaByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateReservaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Reserva as Reserva");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Reserva", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateReservaByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva createReserva() {
		return new sicavibe.Reserva();
	}
	
	public static boolean save(sicavibe.Reserva reserva) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().saveObject(reserva);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(SicaVibe.Reserva reserva)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sicavibe.Reserva reserva) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().deleteObject(reserva);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(SicaVibe.Reserva reserva)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sicavibe.Reserva reserva) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().refresh(reserva);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(SicaVibe.Reserva reserva)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(sicavibe.Reserva reserva) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().evict(reserva);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(SicaVibe.Reserva reserva)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Reserva loadReservaByCriteria(ReservaCriteria reservaCriteria) {
		Reserva[] reservas = listReservaByCriteria(reservaCriteria);
		if(reservas == null || reservas.length == 0) {
			return null;
		}
		return reservas[0];
	}
	
	public static Reserva[] listReservaByCriteria(ReservaCriteria reservaCriteria) {
		return reservaCriteria.listReserva();
	}
}
