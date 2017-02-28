package kasetdormitory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kasetdormitory.model.category;
import kasetdormitory.model.categoryDao;
import kasetdormitory.model.commentDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private categoryDao catDao;
	@Autowired
	private commentDao comDao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String adminIndex(Model model) {
		model.addAttribute("category", catDao.findAll());
		return "/admin/admin-index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView catadd(@RequestParam("addcat") String name) {
		catDao.save(new category(name));
		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable Long id) {
		catDao.delete(id);
		return new ModelAndView("redirect:/admin");
	}
	

	@RequestMapping(value = "/{id}/edit-category", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		category cate = catDao.findOne(id);
		model.addAttribute("caes", cate);
		return "/admin/edit-category";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("upcat") String name,@RequestParam("id") Long id){
		category cate = catDao.findOne(id);
		cate.setName(name);
		catDao.save(cate);
		return new ModelAndView("redirect:/admin");
	}
	
	@RequestMapping(value = "/uc", method = RequestMethod.GET)
	public ModelAndView userComment(Model model) {
		model.addAttribute("comment", comDao.findAll());
		return new ModelAndView("/admin/userComment");
	}
	
	@RequestMapping(value = "/{id}/deletecomment", method = RequestMethod.GET)
	public ModelAndView deleteComment(@PathVariable Long id) {
		comDao.delete(id);
		return new ModelAndView("redirect:/admin/uc");
	}
}
