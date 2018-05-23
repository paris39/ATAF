/**
 * 
 */
package org.ataf.persistence.dao.interfaces;

import java.util.List;

import org.ataf.entities.Role;
import org.ataf.entities.User;

/**
 * @author javier.paris
 */
public interface RoleDAO {
	
	/**
	 * Listado de todos los roles
	 * 
	 * @return Lista de todos los roles de la aplicación
	 */
	public List<Role> getRolList();
	
	/**
	 * Listado de todos los roles de un determinado usuario
	 * @param user
	 * @return Lista de todos los roles de un determinado usuario
	 */
	public List<Role> getRolList(User user);
}