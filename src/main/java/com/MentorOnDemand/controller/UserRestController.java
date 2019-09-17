package com.MentorOnDemand.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Mentor;
import com.MentorOnDemand.model.User;
import com.MentorOnDemand.repository.LoginDao;
import com.MentorOnDemand.repository.MentorDao;
import com.MentorOnDemand.repository.UserDao;
import com.MentorOnDemand.service.AdminService;
import com.MentorOnDemand.service.MentorService;
import com.MentorOnDemand.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired

	MentorDao mentorDao;
	@Autowired
	UserDao userDao;
	@Autowired
	LoginDao loginDao;
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private MentorService mentorService;
	@PostMapping("/user/register")
	public User insertUser(@RequestBody User user)
	{
		User insertUser=userDao.save(user);
		Login insertLogin=loginDao.save(new Login(user));
		return insertUser;
		
		
	}
	
	@GetMapping(path = "/user/searchSkill")
	public ArrayList<Mentor> getMentorList(@RequestBody Mentor mentor) throws Exception {
		ModelAndView mv = new ModelAndView();

		List<Mentor> mentorList = mentorDao.findBySkillsAndSlotTime(mentor.getSkills(), mentor.getSlotTime());
		System.out.println(mentorList);
		/*
		 * if (mentorList.isEmpty()) { System.out.prin } else {
		 * mv.addObject("mentorList", mentorList); mv.setViewName("AdminSearch"); }
		 */
		return (ArrayList<Mentor>) mentorList;
	}

	@PostMapping("/login")
	public int loginUser(@RequestBody Login login,HttpServletRequest request, ModelMap map,HttpSession session)
	{
		int accessValue=0;
		List<Login> login1 = loginDao.findByRole(login.getEmail(), login.getPassword());
		String role = login1.get(0).getRole();
		System.out.println(role);
		long id = 0;
		if (role.equalsIgnoreCase("user")) {
			if (login1.get(0).getAccess() == 0) {
				/*
				 * System.out.println(login1.get(0).getAccess()); id =
				 * userDao.findByUserId(login.getEmail()); map.addAttribute("mentor", new
				 * Mentor()); ArrayList<Skills> skillList = userService.getSkillList();
				 * map.addAttribute("skillsList", skillList);
				 * 
				 * session = request.getSession(); session.setAttribute("name", id);
				 */
				accessValue=1;
			} else {
				/*
				 * map.addAttribute("login", new Login()); ArrayList<Skills> skillList =
				 * userService.getSkillList(); map.addAttribute("skillsList", skillList);
				 * map.addAttribute("mentor", new Mentor());
				 */
				accessValue=0;
			}
		}

		else if (role.equalsIgnoreCase("mentor")) {
			if (login1.get(0).getAccess() == 0) {

				/*
				 * id = mentorDao.findByMentorId(login.getEmail()); session =
				 * request.getSession(); session.setAttribute("name", id);
				 */
				accessValue=2;
			} else {
				/*
				 * map.addAttribute("login", new Login()); ArrayList<Skills> skillList =
				 * userService.getSkillList(); map.addAttribute("skillsList", skillList);
				 * map.addAttribute("mentor", new Mentor());
				 */
				accessValue=0;
			}
		} else if (role.equalsIgnoreCase("admin")) {
			/*
			 * session = request.getSession(); session.setAttribute("name", "admin");
			 */
			accessValue=3;
		}
		return accessValue;

		
		
	}

}
