/**
 * 
 */
package org.ataf.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.ataf.entities.Role;
import org.ataf.entities.User;
import org.ataf.persistence.dao.interfaces.RoleDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * @author javier.paris
 */
public class RoleDAOImpl implements RoleDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleDAOImpl.class);
	private SessionFactory sessionFactory;
	
	/**
	 * Constructor
	 */
	public RoleDAOImpl() {
		super();
	}

	/**
	 * @param sessionFactory
	 */
	public RoleDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Role> getRolList() {
		LOGGER.info("Listing Roles");
		List<Role> rolList = new ArrayList<Role>();
		try {
			rolList = (List<Role>) sessionFactory.getCurrentSession().createCriteria(Role.class).list();
		} catch (Exception e) {
			// Algún tipo de control de excepción TODO
		} finally {
			//sessionFactory.close(); // Cerrando la sesión
		}
 
		return rolList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Role> getRolList(User user) {
		LOGGER.info("Listing Roles {}", new String[] { user.getAlias() });
		List<Role> rolList = new ArrayList<Role>();
		
		try {
			Criterion criterion = Restrictions.eq("id_user", user.getId());
			sessionFactory.getCurrentSession().createCriteria(Role.class).add(criterion);
			rolList = (List<Role>) sessionFactory.getCurrentSession().createCriteria(Role.class)
					.add(Restrictions.or(criterion)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		} catch (Exception e) {
			// Algún tipo de control de excepción TODO
		} finally {
			//sessionFactory.close(); // Cerrando la sesión
		}
		
		return rolList;
	}

}