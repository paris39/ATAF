/**
 * 
 */
package org.ataf.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

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
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = -8880286879587204215L;
	// Estáticos
	private static final Logger LOGGER = LoggerFactory.getLogger(UserAction.class);
	private static final String SUCCESS = "SUCCESS";
	private static final String ERROR = "ERROR";
	
	// DAOs
	private UserDAO userDAO;
	
	// Listados y objetos	
	private User user;
	private List<User> userList;
	
	/**
	 * Palabra a buscar en el formulario de búsqueda
	 */
	private String userSearchText;
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String addUser() throws Exception {
		LOGGER.debug("Exceute UserAction.addUser()");
		Map<String, Object> session = ActionContext.getContext().getSession();
        
		try {
			if (userDAO.newUser(user)) {
//				session.put("context", new Date());
//	        	session.put("logined", true); // Hay usuario logueado
//	        	session.put("loginError", false); // No hay error al loguearse
//	  			session.put("user", user); // Nombre del usuario logueado
				
				session.put("messageFlag", true); // Interruptor de usuario modificado para visualizar mensaje al recargar la página
				// Extrayendo idioma de la aplicación
				if (null != session.get("languageSelected").toString() && !("".equalsIgnoreCase(session.get("languageSelected").toString().trim()))) {
					String lang = new String("");
					String country = new String("");
					lang = session.get("languageSelected").toString().substring(0, session.get("languageSelected").toString().lastIndexOf("_"));
					country = session.get("languageSelected").toString().substring(session.get("languageSelected").toString().lastIndexOf("_") + 1);
					ResourceBundle rb = ResourceBundle.getBundle("i18n", new Locale(lang, country));
					session.put("messageBody", rb.getString("user.addedMessage")); // Mensaje de que ha sido añadido el usuario
				}	
				
	            return SUCCESS;
			} else {
				session.put("logined", false);
		        session.put("loginError", true);
				return ERROR;
			}
		} catch (Exception e) {
			session.put("logined", false);
	        session.put("loginError", true);
	        
			return ERROR;
		}
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String cancelAddUser() throws Exception {
		LOGGER.debug("Execute cancelAddUser");
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		try {
			session.put("activeLink", "ADMIN"); // Se cancela la insercción del usuario y regresa a la página aneterior
			
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String cancelModifyUser() throws Exception {
		LOGGER.debug("Execute cancelModifyUser");
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		try {
			session.put("userReadOnly", true); // Valor para controlar los campos de sólo lectura y que puedan ser desbloqueados al Modificar el árbitro
			session.put("userModifyFlag", false); // Interruptor de modificación de árbitro
			session.put("userCssClassTextField", Util.CLASS_READ_ONLY); // Clase de estilos para visualizar campos de sólo lectura
			
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String getUserListFunction() throws Exception {
		LOGGER.debug("Execute UserAction");
		Map<String, Object> session = ActionContext.getContext().getSession();
		this.userList = new ArrayList<User>();
		
		try {
			if (null != this.userSearchText && !("".equalsIgnoreCase(this.userSearchText.trim()))) {
				this.userList = userDAO.getUserList(userSearchText);
			} else {
				this.userList = userDAO.getUserList();			
			}
			if (this.userList.size() == 0) {
				this.userList = null;
			}
			// HttpSession session = ServletActionContext.getRequest().getSession();
			// session.setAttribute("logined","true");
			// session.setAttribute("context", new Date());
			// Better is using ActionContext 
        	session.put("context", new Date());
        	session.remove("activeLink");
        	session.put("activeLink", "USER");
        	session.put("userListResult", this.getUserList());
        	session.put("userLastSearch", userSearchText); // Para mostrar en el cuadro de búsqueda el valor de la última búsqueda
        	session.put("userFlag", true); // Para que no se vuelva a recargar la página automáticamente (Interruptor)
        	session.put("messageFlag", false); // Interruptor de usuario modificado para visualizar mensaje al recargar la página
			session.remove("messageBody");
        	
        	return SUCCESS;
        } catch (Exception e) {
        	return ERROR;
        }
    }
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String modifyUser() throws Exception {
		LOGGER.debug("Execute modifyUser");
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		try {
			if (null != session.get("userReadOnly") && !(boolean) session.get("userReadOnly")) {
				// Asginando NULL a campos vacíos ("")
//				if ("".equalsIgnoreCase(referee.getAddress().trim())) {
//					referee.setAddress(null);
//				}
//				if ("".equalsIgnoreCase(referee.getCity().trim())) {
//					referee.setCity(null);
//				}
//				if ("".equalsIgnoreCase(referee.getCountry().trim())) {
//					referee.setCountry(null);
//				}
//				if ("".equalsIgnoreCase(referee.getAlias().trim())) {
//					referee.setAlias(null);
//				}
				
				updateUser(this.user); // Actualizar usuario
				
				String result = searchUser();
				
				session.put("messageFlag", true); // Interruptor de usuario modificado para visualizar mensaje al recargar la página
				// Extrayendo idioma de la aplicación
				if (null != session.get("languageSelected").toString() && !("".equalsIgnoreCase(session.get("languageSelected").toString().trim()))) {
					String lang = new String("");
					String country = new String("");
					lang = session.get("languageSelected").toString().substring(0, session.get("languageSelected").toString().lastIndexOf("_"));
					country = session.get("languageSelected").toString().substring(session.get("languageSelected").toString().lastIndexOf("_") + 1);
					ResourceBundle rb = ResourceBundle.getBundle("i18n", new Locale(lang, country));
					session.put("messageBody", rb.getString("user.updatedMessage")); // Mensaje de que ha sido modificado el usuario
				}				
				session.put("userReadOnly", true); // Valor para controlar los campos de sólo lectura y que puedan ser desbloqueados al Modificar el usuario
				session.put("userModifyFlag", false); // Interruptor de modificación de usuario
				session.put("userCssClassTextField", Util.CLASS_READ_ONLY); // Clase de estilos para visualizar campos de sólo lectura
				
				return result;
			} else {
				session.put("messageFlag", false); // Interruptor de árbitro modificado para visualizar mensaje al recargar la página
				session.remove("messageBody"); // Mensaje de que ha sido modificado el árbitro
				session.put("userReadOnly", false); // Valor para controlar los campos de sólo lectura y que puedan ser desbloqueados al Modificar el usuario
				session.put("userModifyFlag", true); // Interruptor de modificación de usuario
				session.put("userCssClassTextField", Util.CLASS_CAN_WRITE); // Clase de estilos para visualizar campos que se puedan modificar
			}
			
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String userFormReset() throws Exception {
		LOGGER.debug("Execute refereeFormReset");
		Map<String, Object> session = ActionContext.getContext().getSession();
		
		try {
			session.put("context", new Date());
			session.remove("activeLink");
			session.put("activeLink", "USER");
			session.remove("userListResult");
			session.remove("userLastSearch");
			session.remove("userFlag");
			session.put("userFlag", false);
			session.put("messageFlag", false); // Interruptor de usuario modificado para visualizar mensaje al recargar la página
			session.remove("messageBody");
			
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	public String searchUser() throws Exception {
		LOGGER.debug("Execute searchUser");
		Map<String, Object> session = ActionContext.getContext().getSession();
		Util.cleanSessionVariables(); // Limpieza de variables de sesión en general
		
		try {
			// Cargar información
			if (null != this.user.getId()) {
				this.user = this.userDAO.getUser(this.user.getId());
				if (null != this.user) {	// Buscar usuario
					session.put("context", new Date());
					session.remove("activeLink");
					session.put("activeLink", "USER_INFO");
					session.remove("userResult");
					session.put("userResult", this.user);
					session.put("userFlag", false);
					
					return SUCCESS;			
				} else {
					return ERROR;
				}
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	/**
	 * @param referee
	 */
	private void updateUser(User user) {
		LOGGER.debug("Execute UserAction.updateUser");
		
		try {
			userDAO.updateUser(user);
		} catch (Exception e) {
			
		}
		LOGGER.debug("End UserAction.updateUser");
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

	/**
	 * @return the userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	/**
	 * @return the userSearchText
	 */
	public String getUserSearchText() {
		return userSearchText;
	}

	/**
	 * @param userSearchText the searchText to set
	 */
	public void setUserSearchText(String userSearchText) {
		this.userSearchText = userSearchText;
	}
	
}