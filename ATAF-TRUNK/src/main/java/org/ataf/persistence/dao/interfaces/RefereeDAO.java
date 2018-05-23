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
	 * @return Lista de todos los �rbitros de la aplicaci�n
	 */
	public List<Referee> getRefereeList();
	
	/**
	 * @param refereeSearchText
	 * @return Lista de los �rbitros encontrados mediante el par�metro
	 */
	public List<Referee> getRefereeList(String refereeSearchText);
	
	
	/**
	 * @param id
	 * @return Objeto de �rbitro
	 */
	public Referee getReferee(Long id);
	
	/**
	 * @param referee
	 */
	public void updateReferee(Referee referee);
}