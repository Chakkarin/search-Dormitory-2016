package kasetdormitory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kasetdormitory.model.user;
import kasetdormitory.model.userDao;

@Controller
@RequestMapping("/")
public class userController {
	@Autowired
	private userDao userDao;
	
	
	@RequestMapping(value="/regis" , method = RequestMethod.POST)
	public ModelAndView regis(Model model,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("pass") String pass,String status){
		String a = "user";
		status = a;
		userDao.save(new user(name, email, pass, status));
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/admin/user",method=RequestMethod.GET)
	public String showuser(Model model){
		model.addAttribute("showUser",userDao.findAll());
		return "admin/showUser";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
