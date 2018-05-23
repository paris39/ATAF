/**
 * 
 */
package org.ataf.persistence.dao.interfaces;

import java.util.List;

import org.ataf.entities.User;

/**
 * @author javier.paris
 */
public interface UserDAO {
	
	/**
	 * Funci�n que comprueba las credenciales para loguearse en la aplicaci�n
	 * 
	 * @param user name/password
	 * @return completed User
	 */
	public User checkLogin (User user);
	
	/**
	 * Funci�n para a�adir un nuevo usuario
	 * 
	 * @param user
	 * @return
	 */
	public boolean newUser (User user);
	
	/**
	 * Listado de todos los usuarios
	 * 
	 * @return Lista de todos los usuarios de la aplicaci�n
	 */
	public List<User> getUserList();
	
	/**
	 * @param userSearchText
	 * @return Lista de los usuarios encontrados mediante el par�metro
	 */
	public List<User> getUserList(String userSearchText);
	
	/**
	 * @param id
	 * @return Objeto de usuario
	 */
	public User getUser(Long id);
	
	/**
	 * @param user
	 */
	public void updateUser(User user);
}