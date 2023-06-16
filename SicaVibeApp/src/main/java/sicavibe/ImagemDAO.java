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

public class ImagemDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(ImagemDAO.class);
	public static Imagem loadImagemByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadImagemByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("loadImagemByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem getImagemByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getImagemByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("getImagemByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem loadImagemByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadImagemByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadImagemByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem getImagemByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getImagemByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getImagemByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem loadImagemByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Imagem) session.load(sicavibe.Imagem.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("loadImagemByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem getImagemByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Imagem) session.get(sicavibe.Imagem.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("getImagemByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem loadImagemByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Imagem) session.load(sicavibe.Imagem.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadImagemByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem getImagemByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Imagem) session.get(sicavibe.Imagem.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getImagemByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryImagem(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryImagem(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryImagem(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryImagem(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryImagem(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryImagem(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem[] listImagemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listImagemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listImagemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem[] listImagemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listImagemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listImagemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryImagem(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Imagem as Imagem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listImagemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryImagem(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Imagem as Imagem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Imagem", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listImagemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem[] listImagemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryImagem(session, condition, orderBy);
			return (Imagem[]) list.toArray(new Imagem[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listImagemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem[] listImagemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryImagem(session, condition, orderBy, lockMode);
			return (Imagem[]) list.toArray(new Imagem[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listImagemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem loadImagemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadImagemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadImagemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem loadImagemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadImagemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadImagemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem loadImagemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Imagem[] imagems = listImagemByQuery(session, condition, orderBy);
		if (imagems != null && imagems.length > 0)
			return imagems[0];
		else
			return null;
	}
	
	public static Imagem loadImagemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Imagem[] imagems = listImagemByQuery(session, condition, orderBy, lockMode);
		if (imagems != null && imagems.length > 0)
			return imagems[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateImagemByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateImagemByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateImagemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateImagemByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateImagemByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateImagemByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateImagemByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Imagem as Imagem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateImagemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateImagemByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Imagem as Imagem");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Imagem", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateImagemByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem createImagem() {
		return new sicavibe.Imagem();
	}
	
	public static boolean save(sicavibe.Imagem imagem) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().saveObject(imagem);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(SicaVibe.Imagem imagem)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sicavibe.Imagem imagem) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().deleteObject(imagem);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(SicaVibe.Imagem imagem)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sicavibe.Imagem imagem) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().refresh(imagem);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(SicaVibe.Imagem imagem)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(sicavibe.Imagem imagem) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().evict(imagem);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(SicaVibe.Imagem imagem)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Imagem loadImagemByCriteria(ImagemCriteria imagemCriteria) {
		Imagem[] imagems = listImagemByCriteria(imagemCriteria);
		if(imagems == null || imagems.length == 0) {
			return null;
		}
		return imagems[0];
	}
	
	public static Imagem[] listImagemByCriteria(ImagemCriteria imagemCriteria) {
		return imagemCriteria.listImagem();
	}
}
