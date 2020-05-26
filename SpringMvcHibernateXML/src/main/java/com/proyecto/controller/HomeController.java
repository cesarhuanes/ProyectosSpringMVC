package com.proyecto.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.dao.UserDAO;
import com.proyecto.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value="/")
	public ModelAndView home() {
		List<User> listUsers = userDao.list();
		ModelAndView model = new ModelAndView("UserList");
		model.addObject("userList", listUsers);
		return model;
	}
	@RequestMapping(value="/new" ,method=RequestMethod.GET)
	public ModelAndView newUser() {
		ModelAndView model=new ModelAndView("UserForm");
	    model.addObject("user",new User());
	    return model;
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
	int idUser=Integer.parseInt(request.getParameter("id"));
	User user=userDao.getIdUser(idUser);
	ModelAndView model=new ModelAndView("UserForm");
	model.addObject("user", user);
	return model;
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		int idUser=Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(idUser);
     return  new  ModelAndView("redirect:/");	
	}
	
	@RequestMapping(value="/save" ,method=RequestMethod.POST)
	public ModelAndView saveUpdate(@ModelAttribute User user) {
		userDao.saveorUpdateUser(user);
		return  new  ModelAndView("redirect:/");
	}
	
}
