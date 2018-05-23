/**
 * 
 */
package org.ataf.persistence.dao.interfaces;

import java.util.List;

import org.ataf.entities.Referee;
import org.ataf.entities.Season;

/**
 * @author javier.paris
 */
public interface SeasonDAO {
	
	/**
	 * @return Lista de todos las temporadas de la aplicación
	 */
	public List<Season> getSeasonList();
	
	
	/**
	 * @param referee
	 * @return Listado de temporadas en las que ha participado un determinado árbitro
	 */
	public List<Season> getSeasonList(Referee referee);
}