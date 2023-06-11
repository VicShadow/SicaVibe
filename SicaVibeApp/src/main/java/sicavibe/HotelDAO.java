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

public class HotelDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(HotelDAO.class);
	public static Hotel loadHotelByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadHotelByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("loadHotelByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel getHotelByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getHotelByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("getHotelByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel loadHotelByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadHotelByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadHotelByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel getHotelByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getHotelByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getHotelByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel loadHotelByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Hotel) session.load(sicavibe.Hotel.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("loadHotelByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel getHotelByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Hotel) session.get(sicavibe.Hotel.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("getHotelByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel loadHotelByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Hotel) session.load(sicavibe.Hotel.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadHotelByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel getHotelByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Hotel) session.get(sicavibe.Hotel.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getHotelByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryHotel(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryHotel(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryHotel(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryHotel(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryHotel(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryHotel(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel[] listHotelByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listHotelByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listHotelByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel[] listHotelByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listHotelByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listHotelByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryHotel(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Hotel as Hotel");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listHotelByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryHotel(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Hotel as Hotel");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Hotel", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listHotelByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel[] listHotelByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryHotel(session, condition, orderBy);
			return (Hotel[]) list.toArray(new Hotel[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listHotelByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel[] listHotelByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryHotel(session, condition, orderBy, lockMode);
			return (Hotel[]) list.toArray(new Hotel[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listHotelByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel loadHotelByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadHotelByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadHotelByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel loadHotelByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadHotelByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadHotelByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel loadHotelByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Hotel[] hotels = listHotelByQuery(session, condition, orderBy);
		if (hotels != null && hotels.length > 0)
			return hotels[0];
		else
			return null;
	}
	
	public static Hotel loadHotelByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Hotel[] hotels = listHotelByQuery(session, condition, orderBy, lockMode);
		if (hotels != null && hotels.length > 0)
			return hotels[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateHotelByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateHotelByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateHotelByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHotelByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateHotelByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateHotelByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHotelByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Hotel as Hotel");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateHotelByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHotelByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Hotel as Hotel");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Hotel", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateHotelByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel createHotel() {
		return new sicavibe.Hotel();
	}
	
	public static boolean save(sicavibe.Hotel hotel) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().saveObject(hotel);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(SicaVibe.Hotel hotel)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sicavibe.Hotel hotel) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().deleteObject(hotel);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(SicaVibe.Hotel hotel)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sicavibe.Hotel hotel) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().refresh(hotel);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(SicaVibe.Hotel hotel)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(sicavibe.Hotel hotel) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().evict(hotel);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(SicaVibe.Hotel hotel)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Hotel loadHotelByCriteria(HotelCriteria hotelCriteria) {
		Hotel[] hotels = listHotelByCriteria(hotelCriteria);
		if(hotels == null || hotels.length == 0) {
			return null;
		}
		return hotels[0];
	}
	
	public static Hotel[] listHotelByCriteria(HotelCriteria hotelCriteria) {
		return hotelCriteria.listHotel();
	}
}
