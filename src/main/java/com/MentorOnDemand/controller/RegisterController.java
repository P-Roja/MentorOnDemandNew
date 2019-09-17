package com.MentorOnDemand.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.MentorOnDemand.repository.LoginDao;
import com.MentorOnDemand.repository.MentorDao;
import com.MentorOnDemand.repository.UserDao;
import com.MentorOnDemand.model.Admin;
import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Mentor;
import com.MentorOnDemand.model.Skills;
import com.MentorOnDemand.model.User;
import com.MentorOnDemand.service.AdminService;
import com.MentorOnDemand.service.MentorService;
import com.MentorOnDemand.service.UserService;

@Controller
public class RegisterController {
	@Autowired

	LoginDao loginDao;
	@Autowired

	MentorDao mentorDao;
	@Autowired

	UserDao userDao;
	@Autowired
	private UserService userService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private MentorService mentorService;

	@RequestMapping("/registerUser")
	public ModelAndView insertUser(ModelMap map) throws SQLException {
		ModelAndView mav = null;
		map.addAttribute("user", new User());
		mav = new ModelAndView("UserRegister");
		return mav;

	}

	@RequestMapping("/registerMentor")
	public ModelAndView insertMentor(ModelMap map) throws SQLException {
		ModelAndView mav = null;
		ArrayList<Skills> skillList = userService.getSkillList();
		map.addAttribute("mentor", new Mentor());
		map.addAttribute("skillsList", skillList);
		mav = new ModelAndView("MentorRegister");
		return mav;

	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, ModelMap map, HttpServletRequest request) {
		ModelAndView mav = null;

		map.addAttribute("login", new Login());
		ArrayList<Skills> skillList = userService.getSkillList();
		map.addAttribute("skillsList", skillList);
		map.addAttribute("mentor", new Mentor());
		mav = new ModelAndView("Login");
		return mav;

	}
	/*
	 * @RequestMapping("/logout") public ModelAndView loginPage(ModelMap map) {
	 * ModelAndView mav = null; map.addAttribute("user", new User()); mav = new
	 * ModelAndView("Login"); return mav;
	 * 
	 * }
	 */
	@RequestMapping("/")
	public ModelAndView login(ModelMap map) throws SQLException {
		ModelAndView mav = null;
		map.addAttribute("login", new Login());
		ArrayList<Skills> skillList = userService.getSkillList();
		map.addAttribute("skillsList", skillList);
		map.addAttribute("mentor", new Mentor());
		mav = new ModelAndView("Login");
		return mav;

	}
	/*
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUSer(@ModelAttribute("user") @Valid User user, BindingResult result,
			HttpServletRequest request, ModelMap map) throws SQLException {
		ModelAndView mav = null;
		if (result.hasErrors()) {
			mav = new ModelAndView("UserRegister");
			return mav;
		}
		userService.registerUser(user);
		loginDao.save(new Login(user.getEmail(), user.getPassword(), user.getRole(), user.getAccess()));
		map.addAttribute("login", new Login());
		mav = new ModelAndView("redirect:/loginAdmin");
		return mav;

	}
*/
	@RequestMapping(value = "/registerMentor", method = RequestMethod.POST)
	public ModelAndView registerMentor(@ModelAttribute("mentor") @Valid Mentor mentor, BindingResult result,
			HttpServletRequest request, ModelMap map) throws SQLException {
		ModelAndView mav = null;
		if (result.hasErrors()) {
			mav = new ModelAndView("UserRegister");
			return mav;
		}
		mentorService.registerMentor(mentor);
		loginDao.save(new Login(mentor.getEmail(), mentor.getPassword(), mentor.getRole(), mentor.getAccess()));
		map.addAttribute("login", new Login());
		mav = new ModelAndView("redirect:/loginAdmin");
		return mav;

	}

	@RequestMapping("/loginAdmin")
	public ModelAndView loginPagee(ModelMap map) throws SQLException {
		ModelAndView mav = null;
		map.addAttribute("login", new Login());
		ArrayList<Skills> skillList = userService.getSkillList();
		map.addAttribute("skillsList", skillList);
		map.addAttribute("mentor", new Mentor());
		mav = new ModelAndView("Login");
		return mav;

	}

	@RequestMapping(path = "/loginAdmin", method = RequestMethod.POST)
	public ModelAndView loginAdmin(@ModelAttribute("login") @Valid Login login, BindingResult result,
			HttpServletRequest request, ModelMap map, HttpSession session) throws SQLException {
		ModelAndView mav = null;
		List<Login> login1 = loginDao.findByRole(login.getEmail(), login.getPassword());
		String role = login1.get(0).getRole();
		System.out.println(role);
		long id = 0;
		if (role.equalsIgnoreCase("user")) {
			if (login1.get(0).getAccess() == 0) {
				System.out.println(login1.get(0).getAccess());
				id = userDao.findByUserId(login.getEmail());
				map.addAttribute("mentor", new Mentor());
				ArrayList<Skills> skillList = userService.getSkillList();
				map.addAttribute("skillsList", skillList);

				session = request.getSession();
				session.setAttribute("name", id);
				mav = new ModelAndView("UserLandingPage");
			} else {
				map.addAttribute("login", new Login());
				ArrayList<Skills> skillList = userService.getSkillList();
				map.addAttribute("skillsList", skillList);
				map.addAttribute("mentor", new Mentor());
				mav = new ModelAndView("Login");
				map.addAttribute("blocked", "blocked");
				mav = new ModelAndView("Login");
			}
		}

		else if (role.equalsIgnoreCase("mentor")) {
			if (login1.get(0).getAccess() == 0) {

				id = mentorDao.findByMentorId(login.getEmail());
				session = request.getSession();
				session.setAttribute("name", id);
				mav = new ModelAndView("MentorLandingPage");
			} else {
				map.addAttribute("login", new Login());
				ArrayList<Skills> skillList = userService.getSkillList();
				map.addAttribute("skillsList", skillList);
				map.addAttribute("mentor", new Mentor());
				mav = new ModelAndView("Login");
				map.addAttribute("blocked", "blocked");
				mav = new ModelAndView("Login");
			}
		} else if (role.equalsIgnoreCase("admin")) {
			session = request.getSession();
			session.setAttribute("name", "admin");
			mav = new ModelAndView("AdminLandingPage");
		}
		return mav;

	}

}
