/**
 * 
 */
package org.ataf.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.ataf.entities.Referee;
import org.ataf.entities.Season;
import org.ataf.persistence.dao.interfaces.SeasonDAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * @author javier.paris
 */
public class SeasonDAOImpl implements SeasonDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SeasonDAOImpl.class);
	private SessionFactory sessionFactory;
	
	/**
	 * Constructor
	 */
	public SeasonDAOImpl() {
		super();
	}
	
	/**
	 * @param sessionFactory
	 */
	public SeasonDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Season> getSeasonList() {
		LOGGER.info("Listing Seasons");
		List<Season> listSeason = new ArrayList<Season>();
		try {
			Order order = Order.desc("name");
			listSeason = (List<Season>) sessionFactory.getCurrentSession().createCriteria(Season.class).addOrder(order).list();
		} catch (Exception e) {
			// Algún tipo de control de excepción TODO
		} finally {
			//sessionFactory.close(); // Cerrando la sesión
		}
 
		return listSeason;
	}


	@Override
	@Transactional
	public List<Season> getSeasonList(Referee referee) {
		// TODO Auto-generated method stub
		return null;
	}

}