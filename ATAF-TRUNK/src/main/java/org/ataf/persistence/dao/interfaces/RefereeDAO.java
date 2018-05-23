/**
 * 
 */
package org.ataf.persistence.dao.interfaces;

import java.util.List;

import org.ataf.entities.Referee;

/**
 * @author javier.paris
 */
public interface RefereeDAO {
	
	/**
	 * @return Lista de todos los árbitros de la aplicación
	 */
	public List<Referee> getRefereeList();
	
	/**
	 * @param refereeSearchText
	 * @return Lista de los árbitros encontrados mediante el parámetro
	 */
	public List<Referee> getRefereeList(String refereeSearchText);
	
	
	/**
	 * @param id
	 * @return Objeto de árbitro
	 */
	public Referee getReferee(Long id);
	
	/**
	 * @param referee
	 */
	public void updateReferee(Referee referee);
}