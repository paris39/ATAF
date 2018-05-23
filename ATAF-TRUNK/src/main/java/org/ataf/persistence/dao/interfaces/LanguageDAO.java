/**
 * 
 */
package org.ataf.persistence.dao.interfaces;

import java.util.List;

import org.ataf.entities.Language;

/**
 * @author javier.paris
 *
 */
public interface LanguageDAO {
	
	/**
	 * @return Lista de todos las temporadas de la aplicaci�n
	 */
	public List<Language> getLanguageList();
	
}