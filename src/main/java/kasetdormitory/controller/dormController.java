package kasetdormitory.controller;

import kasetdormitory.model.category;
import kasetdormitory.model.categoryDao;
import kasetdormitory.model.dorm;
import kasetdormitory.model.dormDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class dormController {

	@Autowired
	private dormDao dormDao;
	@Autowired
	private categoryDao categoryDao;
/*	@Autowired
	private Environment env;*/

	@RequestMapping(value = "/sdorm", method = RequestMethod.GET)
	public String ShowDorm(Model model) {
		model.addAttribute("cate", categoryDao.findAll());
		model.addAttribute("dorm", dormDao.findAll());
		return "/admin/show-dorm";
	}

	// add dorm
	@RequestMapping(value = "/dorm/aDorm", method = RequestMethod.GET)
	public String Dorm(Model model) {
		model.addAttribute("cate", categoryDao.findAll());
		model.addAttribute("latilng", dormDao.findAll());
		return "/admin/dorm";
	}

	@RequestMapping(value = "/dorm/add", method = RequestMethod.POST)
	public ModelAndView dormAdd(@RequestParam("lat_value") double lati, @RequestParam("lon_value") double longi,
			@RequestParam("name") String name, @RequestParam("cater") category category,
			@RequestParam("tel") String tel, @RequestParam("water") int price_aqua,
			@RequestParam("fine") int price_fire, @RequestParam("fchecks") String[] consume,
			@RequestParam("price") int price, @RequestParam("dis_va") String dist) {
		dormDao.save(new dorm(name, lati, longi, tel, price, price_aqua, price_fire, dist, consume, category));
		return new ModelAndView("redirect:/admin/dorm/aDorm");
	}

	/*// upload file
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile) {
		try {
			// Get the filename and build the local file path
			String filename = uploadfile.getOriginalFilename();
			String directory = env.getProperty("dorm.uploadedFiles");
			String filepath = Paths.get(directory, filename).toString();
			System.out.println(directory + "/" + filename);
			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(uploadfile.getBytes());
			stream.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	} // method uploadFile
*/
	
	// edit
	@RequestMapping(value = "/{id}/edit-dorm", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		dorm dorm = dormDao.findOne(id);
		model.addAttribute("all", categoryDao.findAll());
		/* model.addAttribute("consu", consuDao.findAll()); */
		model.addAttribute("dorm", dorm);
		return "/admin/edit-dorm";
	}

	@RequestMapping(value = "/dorm/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam("lat_value") double lati, @RequestParam("lon_value") double longi,
			@RequestParam("name") String name, @RequestParam("cater") category category,
			@RequestParam("tel") String tel, @RequestParam("water") int price_aqua,
			@RequestParam("fine") int price_fire, @RequestParam("fchecks") String[] consume,
			@RequestParam("price") int price, @RequestParam("dis_va") String dist,@RequestParam("id") Long id) {
		dorm dorm = dormDao.findOne(id);
		dorm.setLati(lati);
		dorm.setLongi(longi);
		dorm.setName(name);
		dorm.setCategory(category);
		dorm.setTel(tel);
		dorm.setPrice_aqua(price_aqua);
		dorm.setPrice_fire(price_fire);
		dorm.setPrice(price);
		dorm.setDist(dist);
		dorm.setConsume(consume);
		dormDao.save(dorm);
		return new ModelAndView("redirect:/admin/sdorm");
	}

	// delete
	@RequestMapping(value = "/{id}/delete-dorm", method = RequestMethod.GET)
	public ModelAndView deleteDorm(@PathVariable Long id) {
		dormDao.delete(id);
		return new ModelAndView("redirect:/admin/sdorm");
	}

	// test
	@RequestMapping(value = "/dorm/show", method = RequestMethod.GET)
	public String DormshowData(Model model) {
		model.addAttribute("cate", categoryDao.findAll());
		model.addAttribute("dorm", dormDao.findAll());
		return "/admin/show";
	}

}
