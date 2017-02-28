package kasetdormitory.controller;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import kasetdormitory.model.Image;
import kasetdormitory.model.ImageDao;
import kasetdormitory.model.dorm;
import kasetdormitory.model.dormDao;

@Controller
public class uploadController {
	@Autowired
	private ImageDao imgDao;
	@Autowired
	private dormDao dormDao;

	@RequestMapping(value = "/admin/up", method = RequestMethod.GET)
	public String GetFileUpload(Model model) {
		model.addAttribute("dorm", dormDao.findAll());
		//model.addAttribute("Show", imgDao.findAll());
		return "/admin/image";
	}

	@RequestMapping(value = "/admin/up", method = RequestMethod.POST)
	public String handleFileUpload(Model model,@RequestParam("file") MultipartFile file,@RequestParam("idIm") dorm dorm) {
		model.addAttribute("dorm", dormDao.findAll());
		if (!file.isEmpty()) {
			try {
				String Path = "D:/workspace-sts-3.7.2.RELEASE/DormitoryKasetsartCSC/src/main/resources/static/images/"
						+ file.getOriginalFilename();

				FileOutputStream fos = new FileOutputStream(Path);
				fos.write(file.getBytes());
				fos.close();


				imgDao.save(new Image("/images/" + file.getOriginalFilename(), dorm));
/*
				return "<script type=" + "text/javascript"
						+ ">window.alert('You successfully uploaded  into uploaded !');</script>";
				*/
				/*model.addAttribute("sScript","<div class="+"alert alert-success alert-dismissible fade in" +"role="+"alert"+">"+
  "<button type="+"button"+" class="+"close"+" data-dismiss="+"alert"+" aria-label="+"Close"+"/>"+"<span aria-hidden="+"true"+">&times;</span>"+
  "</button> <strong>สำเร็จ!</strong>ทำการเพิ่มรูปภาพแล้ว</div>");*/
				return "/admin/image";
			} catch (Exception e) {
				return "You failed to upload  " + e.getMessage();
			}
		} else {
			return "You failed to upload  because the file was empty.";
		}
	}

/*	@RequestMapping(value = "/sup", method = RequestMethod.GET)
	public String ShowUpload(Model model) {
		model.addAttribute("Show", imgDao.findAll());
		return "/showup";
	}*/

}
