package kasetdormitory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kasetdormitory.model.dormDao;

@Controller
public class TestController {
	@Autowired
	private dormDao dormDao;
	
	@RequestMapping("/test")
	public ModelAndView showMaker(Model model){
		model.addAttribute("show",dormDao.findAll());
		return new ModelAndView("/test");
	}
}
