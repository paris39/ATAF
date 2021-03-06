/**
 * 
 */
package org.ataf.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.ataf.entities.User;
import org.ataf.persistence.dao.interfaces.UserDAO;
import org.ataf.utils.Util;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * @author javier.paris
 */
public class UserDAOImpl implements UserDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);
	private SessionFactory sessionFactory;
	
	/**
	 * Constructor
	 */
	public UserDAOImpl() {
		super();
	}

	/**
	 * @param sessionFactory
	 */
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public User checkLogin(User user) {
		try {
			// B�squeda en base de datos del usuario que corresponda con el alias introducido
			User userFound = (User) sessionFactory.getCurrentSession()
	                .createCriteria(User.class).add(Restrictions.eq("alias", user.getAlias()))
	                .setFetchMode("roles", FetchMode.JOIN).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
	                .uniqueResult();
//			userFound.getRoles().isEmpty(); // Acceso obligatorio al Set ya que si se accede a �l desde otro lado pierde la conexi�n
			return userFound;
		} catch (Exception e) {
			return user;
		}
	}

	@Override
	@Transactional
	public List<User> getUserList() {
		 @SuppressWarnings("unchecked")
		 List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
	}

	@Override
	@Transactional
	public boolean newUser(User user) {
		LOGGER.info("Encrypting password");
		user.setPassword(Util.cryptMD5(user.getPassword()));
		try {
			sessionFactory.getCurrentSession().save(user);
			sessionFactory.getCurrentSession().getTransaction().commit();
			LOGGER.info("Correct save");
			return true;
		} catch (HibernateException e) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
			LOGGER.error("Incorrect save", e);
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> getUserList(String userSearchText) {
		LOGGER.info("Listing Users {}", new String[] { userSearchText });
		List<User> listUser = new ArrayList<User>();
		
		try {
			Criterion criterion = Restrictions.like("name", userSearchText, MatchMode.ANYWHERE);
			Criterion criterion1 = Restrictions.like("surname", userSearchText, MatchMode.ANYWHERE);
			Criterion criterion2 = Restrictions.like("alias", userSearchText, MatchMode.ANYWHERE);
			sessionFactory.getCurrentSession().createCriteria(User.class).add(criterion);
			listUser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.or(criterion, criterion1, criterion2))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		} catch (Exception e) {
			// Alg�n tipo de control de excepci�n TODO
		} finally {
			//sessionFactory.close(); // Cerrando la sesi�n
		}
		
		return listUser;
	}
	
	@Override
	@Transactional
	public User getUser(Long id) {
		LOGGER.info("Getting User {}", new String[] { id.toString() });
		User user = new User();
		try {
			user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		} catch (Exception e) {
			// Alg�n tipo de control de excepci�n TODO
		} finally {
			//sessionFactory.close(); // Cerrando la sesi�n
		}
		
		return user;
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		LOGGER.info("Updating User {}", new String[] { user.getId().toString() });
		try {
			if (null != user) {
				sessionFactory.getCurrentSession().update(user);
			}
		} catch (Exception e) {
			// Alg�n tipo de control de excepci�n TODO
		} finally {
			//sessionFactory.close(); // Cerrando la sesi�n
		}
	}
	
}