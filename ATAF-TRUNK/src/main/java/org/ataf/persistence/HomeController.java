/**
 * 
 */
package org.ataf.persistence;

import java.util.List;

import org.ataf.entities.User;
import org.ataf.persistence.dao.interfaces.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author javier.paris
 */
@Controller
public class HomeController {

	@Autowired
    private UserDAO userDao;
	//private RefereeDAO refereeDao;
	
	@RequestMapping(value="/")
    public ModelAndView home() {
        List<User> listUsers = userDao.getUserList();
        ModelAndView model = new ModelAndView("home");
        model.addObject("userList", listUsers);
        return model;
    }

}