package kasetdormitory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kasetdormitory.model.dormDao;
import kasetdormitory.model.userDao;

@Controller
public class loginController {
	@Autowired
	private userDao userDao;

	@Autowired
	private dormDao dormDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("name") String name, @RequestParam("pass") String password, Model model) {
		/*
		 * long Idname; long Idpass; Idname = userDao.findByName(name).getId();
		 * Idpass = userDao.findByPass(password).getId();
		 */
		try {
			if (userDao.findByName(name).getId() == userDao.findByPass(password).getId()) {
				/*
				 * if( (name.equals(userDao.findByName(name).getName()) &&
				 * (password.equals(userDao.findByPass(password).getPass())))){
				 */
				System.out.println("login success!!");
				if (userDao.findByName(name).getStatus().equals("admin")) {
					return "redirect:/admin";
				} else {
					model.addAttribute("DataDorm", dormDao.findAll());
					model.addAttribute("User", userDao.findByName(name).getName());
					return "/login/index";
				}

				/*
				 * System.out.println(userDao.findByName(name));
				 * System.out.println(userDao.findByPass(password));
				 * System.out.println(userDao.getClass().getName());
				 * System.out.println(user.getPass());
				 */

			} /*
				 * else { System.out.println("login wraning");
				 * 
				 * System.out.println(userDao.findByName(name).getName());
				 * System.out.println(userDao.findByPass(password).getPass());
				 * 
				 * model.addAttribute("DataDorm", dormDao.findAll()); return
				 * "/index"; }
				 */

		} catch (Exception e) {
			System.out.println("Error");
			String Emass ="ชื่อหรือรหัสผ่านไม่ถูกต้องกรุณาทำการเข้าสู่ระบบใหม่อีกครั้ง";
			model.addAttribute("ELogin", Emass);
			return "redirect:/";
		}
		return "redirect:/";
	}
}
