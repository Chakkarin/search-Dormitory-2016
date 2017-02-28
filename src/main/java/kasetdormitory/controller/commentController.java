package kasetdormitory.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kasetdormitory.model.commentDao;
import kasetdormitory.model.dorm;
import kasetdormitory.model.dormDao;
import kasetdormitory.model.user;
import kasetdormitory.model.comment;
import kasetdormitory.model.userDao;
@Controller
public class commentController {
	@Autowired
	private userDao userDao;
	@Autowired
	private commentDao comDao;
	@Autowired
	private dormDao dormDao;
	
	@RequestMapping(value="/comment",method=RequestMethod.POST)
	public String comment(Model model,@RequestParam("dormCom") long dormcom,
			@RequestParam("namelog") String usercom,@RequestParam("star") int star,
			@RequestParam("comment") String message){
		Date commentDate = new Date();
		dorm dorm = dormDao.findById(dormcom);
		long userId = userDao.findByName(usercom).getId();
		user user = userDao.findById(userId);
		comDao.save(new comment(message, star, commentDate, user, dorm));
	return "redirect:/_/"+dormcom+"/show/"+usercom;
	}
}
