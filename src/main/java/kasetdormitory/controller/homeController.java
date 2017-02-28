package kasetdormitory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kasetdormitory.model.ImageDao;
import kasetdormitory.model.categoryDao;
import kasetdormitory.model.commentDao;
import kasetdormitory.model.dorm;
import kasetdormitory.model.dormDao;

@Controller
public class homeController {

	@Autowired
	private dormDao dormDao;
	@Autowired
	private categoryDao catDao;
	@Autowired
	private commentDao comDao;
	@Autowired
	private ImageDao imgDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("DataDorm", dormDao.findAll());
		model.addAttribute("DataCato", catDao.findAll());
		return "/index";
	}

	@RequestMapping(value = "/S", method = RequestMethod.GET)
	public String home1(Model model) {
		model.addAttribute("DataDorm", dormDao.findAll());
		model.addAttribute("DataCato", catDao.findAll());
		return "/index";
	}

	@RequestMapping(value = "/_S", method = RequestMethod.GET)
	public String home2(Model model) {
		
		model.addAttribute("DataDorm", dormDao.findAll());
		model.addAttribute("DataCato", catDao.findAll());
		return "/index";
	}

	/*
	 * @RequestMapping(value = "/sdorm", method = RequestMethod.GET) public
	 * String showDorm(Model model) {
	 * 
	 * return "/showDorm"; }
	 */

	@RequestMapping(value = "/S", method = RequestMethod.POST)
	public ModelAndView Sname(Model model, @RequestParam("nameS") String nameS) {
		model.addAttribute("DataCato", catDao.findAll());
		if (nameS != "") {
			model.addAttribute("DataDorm", dormDao.findByNameContaining(nameS));
		} else {
			model.addAttribute("DataDorm", dormDao.findAll());
		}
		return new ModelAndView("/Search1");
	}

	@RequestMapping(value = "/_S", method = RequestMethod.POST)
	public ModelAndView Sdata(Model model, @RequestParam("fchecks") String[] consume) {
			System.out.println(consume);
			model.addAttribute("DataDorm", dormDao.findByConsumeLike(consume));
			return new ModelAndView("/Search2");
	}

	@RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
	public String showDataDorm(@PathVariable Long id, Model model) {
		dorm dorm = dormDao.findOne(id);
		model.addAttribute("dorm", dorm);

		dorm namedorm = dormDao.findById(id);

		model.addAttribute("Scomment", comDao.findByDorm(namedorm));

		dorm idimge = dormDao.findById(id);
		model.addAttribute("img", imgDao.findByDorm(idimge));

		return "/showDorm";
	}

	////////////////////////////////// LOGIN
	////////////////////////////////// ???????????????????????????????????????????

	@RequestMapping(value = "/_/{id}/show/{namecom}", method = RequestMethod.GET)
	public String loginGshowDataDorm(@PathVariable Long id, Model model, @PathVariable String namecom) {
		dorm dorm = dormDao.findOne(id);
		model.addAttribute("User", namecom);
		long iddorm = dormDao.findById(id).getId();
		model.addAttribute("iddorm", iddorm);
		model.addAttribute("dorm", dorm);
		dorm namedorm = dormDao.findById(id);
		model.addAttribute("Scomment", comDao.findByDorm(namedorm));
		dorm idimge = dormDao.findById(id);
		model.addAttribute("img", imgDao.findByDorm(idimge));

		return "/login/showDorm";
	}

	@RequestMapping(value = "/_/{id}/show", method = RequestMethod.POST)
	public String loginshowDataDorm(@PathVariable Long id, Model model, @RequestParam("namelog") String user) {

		model.addAttribute("dorm", dormDao.findOne(id));
		model.addAttribute("iddorm", dormDao.findById(id).getId());
		model.addAttribute("User", user);
		dorm idimge = dormDao.findById(id);
		model.addAttribute("img", imgDao.findByDorm(idimge));

		dorm namedorm = dormDao.findById(id);
		model.addAttribute("Scomment", comDao.findByDorm(namedorm));
		return "/login/showDorm";
	}

	@RequestMapping(value = "/S.", method = RequestMethod.GET)
	public String Loginhome1(Model model, @RequestParam("namelog") String user) {
		model.addAttribute("User", user);
		model.addAttribute("DataDorm", dormDao.findAll());
		model.addAttribute("DataCato", catDao.findAll());

		return "/login/index";
	}

	@RequestMapping(value = "/S.", method = RequestMethod.POST)
	public ModelAndView LoginSname(Model model, @RequestParam("nameS") String nameS,
			@RequestParam("namelog") String user) {
		model.addAttribute("DataCato", catDao.findAll());
		model.addAttribute("User", user);

		if (nameS != "") {
			model.addAttribute("DataDorm", dormDao.findByNameContaining(nameS));
		} else {
			model.addAttribute("DataDorm", dormDao.findAll());
		}
		return new ModelAndView("/login/Search1");
	}

	@RequestMapping(value = "/_S.", method = RequestMethod.POST)
	public ModelAndView LoginSdata(Model model, @RequestParam("fchecks") String[] consume,
			@RequestParam("namelog") String user) {
		model.addAttribute("User", user);
		System.out.println(consume);
		model.addAttribute("DataDorm", dormDao.findByConsume(consume));
		return new ModelAndView("/login/Search2");
	}
}
