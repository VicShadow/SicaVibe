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

public class FuncionarioDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(FuncionarioDAO.class);
	public static Funcionario loadFuncionarioByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadFuncionarioByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("loadFuncionarioByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario getFuncionarioByORMID(int ID) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getFuncionarioByORMID(session, ID);
		}
		catch (Exception e) {
			_logger.error("getFuncionarioByORMID(int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario loadFuncionarioByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadFuncionarioByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadFuncionarioByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario getFuncionarioByORMID(int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return getFuncionarioByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getFuncionarioByORMID(int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario loadFuncionarioByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Funcionario) session.load(sicavibe.Funcionario.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("loadFuncionarioByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario getFuncionarioByORMID(PersistentSession session, int ID) throws PersistentException {
		try {
			return (Funcionario) session.get(sicavibe.Funcionario.class, Integer.valueOf(ID));
		}
		catch (Exception e) {
			_logger.error("getFuncionarioByORMID(PersistentSession session, int ID)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario loadFuncionarioByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Funcionario) session.load(sicavibe.Funcionario.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadFuncionarioByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario getFuncionarioByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Funcionario) session.get(sicavibe.Funcionario.class, Integer.valueOf(ID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getFuncionarioByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryFuncionario(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryFuncionario(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryFuncionario(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryFuncionario(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return queryFuncionario(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryFuncionario(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario[] listFuncionarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listFuncionarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listFuncionarioByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario[] listFuncionarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return listFuncionarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listFuncionarioByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryFuncionario(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Funcionario as Funcionario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listFuncionarioByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static List queryFuncionario(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Funcionario as Funcionario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Funcionario", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listFuncionarioByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario[] listFuncionarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryFuncionario(session, condition, orderBy);
			return (Funcionario[]) list.toArray(new Funcionario[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listFuncionarioByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario[] listFuncionarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryFuncionario(session, condition, orderBy, lockMode);
			return (Funcionario[]) list.toArray(new Funcionario[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listFuncionarioByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario loadFuncionarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadFuncionarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadFuncionarioByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario loadFuncionarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return loadFuncionarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadFuncionarioByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario loadFuncionarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Funcionario[] funcionarios = listFuncionarioByQuery(session, condition, orderBy);
		if (funcionarios != null && funcionarios.length > 0)
			return funcionarios[0];
		else
			return null;
	}
	
	public static Funcionario loadFuncionarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Funcionario[] funcionarios = listFuncionarioByQuery(session, condition, orderBy, lockMode);
		if (funcionarios != null && funcionarios.length > 0)
			return funcionarios[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateFuncionarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateFuncionarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateFuncionarioByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFuncionarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = sicavibe.SicaVibeMainVPPersistentManager.instance().getSession();
			return iterateFuncionarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateFuncionarioByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFuncionarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Funcionario as Funcionario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateFuncionarioByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateFuncionarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From sicavibe.Funcionario as Funcionario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Funcionario", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateFuncionarioByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario createFuncionario() {
		return new sicavibe.Funcionario();
	}
	
	public static boolean save(sicavibe.Funcionario funcionario) throws PersistentException {
		try {
			PersistentManager vp = sicavibe.SicaVibeMainVPPersistentManager.instance();
			try {
				vp.saveObject(funcionario);
			}
			catch (Exception e) {
				vp.getSession().getTransaction().rollback();
				throw new PersistentException(e);
			}
			return true;
		}
		catch (Exception e) {
			_logger.error("save(SicaVibe.Funcionario funcionario)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(sicavibe.Funcionario funcionario) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().deleteObject(funcionario);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(SicaVibe.Funcionario funcionario)", e);
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(sicavibe.Funcionario funcionario) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().refresh(funcionario);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(SicaVibe.Funcionario funcionario)", e);
			throw new PersistentException(e);
		}
	}

	
	public static boolean evict(sicavibe.Funcionario funcionario) throws PersistentException {
		try {
			sicavibe.SicaVibeMainVPPersistentManager.instance().getSession().evict(funcionario);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(SicaVibe.Funcionario funcionario)", e);
			throw new PersistentException(e);
		}
	}
	
	public static Funcionario loadFuncionarioByCriteria(FuncionarioCriteria funcionarioCriteria) {
		Funcionario[] funcionarios = listFuncionarioByCriteria(funcionarioCriteria);
		if(funcionarios == null || funcionarios.length == 0) {
			return null;
		}
		return funcionarios[0];
	}
	
	public static Funcionario[] listFuncionarioByCriteria(FuncionarioCriteria funcionarioCriteria) {
		return funcionarioCriteria.listFuncionario();
	}
}
