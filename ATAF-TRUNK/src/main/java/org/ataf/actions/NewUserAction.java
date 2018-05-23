/**
 * 
 */
package org.ataf.actions;

import java.util.Date;
import java.util.Map;

import org.ataf.entities.User;
import org.ataf.persistence.dao.interfaces.UserDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * @author javier.paris
 */
public class NewUserAction extends ActionSupport {
	private static final long serialVersionUID = -5416739197692858200L;
	
	// Estáticos
	private static final Logger LOGGER = LoggerFactory.getLogger(NewUserAction.class);
	private static final String SUCCESS = "SUCCESS";
	//private static final String ERROR = "ERROR";
	private static final String LOGIN_ERROR = "LOGIN_ERROR";
	
	private UserDAO userDAO;
	private User user;
	
	public String execute() throws Exception {
		LOGGER.debug("Exceute LoginAction");
		Map<String, Object> session = ActionContext.getContext().getSession();
        if (userDAO.newUser(user)) {
//            HttpSession session = ServletActionContext.getRequest().getSession();
//            session.setAttribute("logined","true");
//            session.setAttribute("context", new Date());
// Better is using ActionContext 
        	session.put("context", new Date());
        	session.put("logined", true); // Hay usuario logueado
        	session.put("loginError", false); // No hay error al loguearse
  			session.put("user", user); // Nombre del usuario logueado
            return SUCCESS;
        }
        //return ERROR;
        session.put("logined", false);
        session.put("loginError", true);
        return LOGIN_ERROR;
    }
 
    /**
     * @return
     * @throws Exception
     */
    public String logout() throws Exception {
//        HttpSession session = ServletActionContext.getRequest().getSession();
//        session.removeAttribute("logined");
//        session.removeAttribute("context"); 
    	Map<String, Object> session = ActionContext.getContext().getSession();
    	session.remove("logined");
        session.remove("context");
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