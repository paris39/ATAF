/**
 * 
 */
package org.ataf.actions;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.ataf.entities.Role;
import org.ataf.entities.User;
import org.ataf.persistence.dao.interfaces.UserDAO;
import org.ataf.utils.Util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * @author javier.paris
 */
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 2883366032742420695L;
	
	// Est�ticos
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginAction.class);
	private static final String SUCCESS = "SUCCESS";
	//private static final String ERROR = "ERROR";
	private static final String LOGIN_ERROR = "LOGIN_ERROR";
	private static final String ADMIN = "admin";
	
	// DAOs
	private UserDAO userDAO;
	private User user;
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		LOGGER.debug("Exceute LoginAction - login");
		Map<String, Object> session = ActionContext.getContext().getSession();
		String userAlias = this.user.getAlias(); // Almacenando el alias introducido
		String userPass = this.user.getPassword(); // Almacenando la password introducida
		setUser(userDAO.checkLogin(this.user)); // B�squeda en base de datos del usuario
		if (null != this.user && this.user.isActive()) { // �El usuario existe y est� activo?
			if (this.user.getAlias().equals(userAlias)) {
				String encryptPass = Util.cryptMD5(userPass); // Encriptando la password introducida
				if (this.user.getPassword().equals(encryptPass)) { // Comparando la password encriptada con la almacenada en bbdd
					// Revisi�n de roles ADMIN
					Iterator<Role> rolesIterator = this.user.getRoles().iterator();
					boolean exit = false; // Variable que controla la salida del bucle
					while (rolesIterator.hasNext() && !exit) {
						Role roleAux = rolesIterator.next();
						// Buscando rol Administrador
						if (ADMIN.equalsIgnoreCase(roleAux.getName()) && roleAux.isActive()) {
							exit = true;
							session.put(ADMIN, true); // Es usuario administrador
						}
					} // End While
					
					session.put("context", new Date());
		        	session.put("logined", true); // Hay usuario logueado
		        	session.put("loginError", false); // No hay error al loguearse
		  			session.put("user", this.user); // Nombre del usuario logueado
		  			
		            return SUCCESS;
				} 
			}
		}
		
		session.remove("admin");
        session.put("logined", false);
        session.put("loginError", true);
        return LOGIN_ERROR;
    }
 
    /**
     * @return
     * @throws Exception
     */
	public String logout() throws Exception {
		LOGGER.debug("Execute LoginAction - logout");
        Map<String, Object> session = ActionContext.getContext().getSession();
        
        // Se eliminan las variables de sesi�n
        session.remove("logined"); 
        session.remove("user");
        session.remove("context");
        session.remove("admin");
        session.put("refereeReadOnly", true);
        session.remove("refereeModifyFlag"); // Interruptor de modificaci�n de �rbitro
        session.remove("refereeUpdatedFlag"); // Interruptor de �rbitro modificado para visualizar mensaje al recargar la p�gina
        
        return SUCCESS;
	}

	/**
	 * @return the userDAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}	
 
}