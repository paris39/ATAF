/**
 * 
 */
package org.ataf.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.ataf.entities.Referee;
import org.ataf.persistence.dao.interfaces.RefereeDAO;
import org.hibernate.Criteria;
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
public class RefereeDAOImpl implements RefereeDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RefereeDAOImpl.class);
	private SessionFactory sessionFactory;
	
	/**
	 * Constructor
	 */
	public RefereeDAOImpl() {
		super();
	}

	/**
	 * @param sessionFactory
	 */
	public RefereeDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Referee> getRefereeList() {
		LOGGER.info("Listing Referees");
		List<Referee> listReferee = new ArrayList<Referee>();
		try {
			listReferee = (List<Referee>) sessionFactory.getCurrentSession().createCriteria(Referee.class).list();
		} catch (Exception e) {
			// Algún tipo de control de excepción TODO
		} finally {
			//sessionFactory.close(); // Cerrando la sesión
		}
 
		return listReferee;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Referee> getRefereeList(String refereeSearchText) {
		LOGGER.info("Listing Referees {}", new String[] { refereeSearchText });
		List<Referee> listReferee = new ArrayList<Referee>();
		
		try {
			Criterion criterion = Restrictions.like("name", refereeSearchText, MatchMode.ANYWHERE);
			Criterion criterion1 = Restrictions.like("surname", refereeSearchText, MatchMode.ANYWHERE);
			Criterion criterion2 = Restrictions.like("alias", refereeSearchText, MatchMode.ANYWHERE);
			sessionFactory.getCurrentSession().createCriteria(Referee.class).add(criterion);
			listReferee = (List<Referee>) sessionFactory.getCurrentSession().createCriteria(Referee.class)
					.add(Restrictions.or(criterion, criterion1, criterion2))
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		} catch (Exception e) {
			// Algún tipo de control de excepción TODO
		} finally {
			//sessionFactory.close(); // Cerrando la sesión
		}
		
		return listReferee;
	}

	@Override
	@Transactional
	public Referee getReferee(Long id) {
		LOGGER.info("Getting Referee {}", new String[] { id.toString() });
		Referee referee = new Referee();
		try {
			referee = (Referee) sessionFactory.getCurrentSession().get(Referee.class, id);
		} catch (Exception e) {
			// Algún tipo de control de excepción TODO
		} finally {
			//sessionFactory.close(); // Cerrando la sesión
		}
		
		return referee;
	}

	@Override
	@Transactional
	public void updateReferee(Referee referee) {
		LOGGER.info("Updating Referee {}", new String[] { referee.getId().toString() });
		try {
			if (null != referee) {
				sessionFactory.getCurrentSession().update(referee);
			}
		} catch (Exception e) {
			// Algún tipo de control de excepción TODO
		} finally {
			//sessionFactory.close(); // Cerrando la sesión
		}
	}
	
}