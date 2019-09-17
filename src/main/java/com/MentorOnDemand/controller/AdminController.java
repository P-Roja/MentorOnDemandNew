package com.MentorOnDemand.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Mentor;
import com.MentorOnDemand.model.ProposalRequest;
import com.MentorOnDemand.model.Skills;
import com.MentorOnDemand.model.User;
import com.MentorOnDemand.repository.AdminDao;
import com.MentorOnDemand.repository.LoginDao;
import com.MentorOnDemand.repository.MentorDao;
import com.MentorOnDemand.repository.ProposeDao;
import com.MentorOnDemand.repository.SkillsDao;
import com.MentorOnDemand.repository.UserDao;
import com.MentorOnDemand.service.AdminService;
import com.MentorOnDemand.service.MentorService;
import com.MentorOnDemand.service.UserService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	UserService userService;
	@Autowired
	MentorService mentorService;
	@Autowired
	MentorDao mentorDao;
	@Autowired
	LoginDao loginDao;
	@Autowired
	AdminDao adminDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ProposeDao prDao;
	@Autowired
	SkillsDao skillDao;

	@RequestMapping("/addSkill")
	public ModelAndView addSkill(ModelMap map) throws SQLException {
		ModelAndView mav = null;
		map.addAttribute("skill", new Skills());
		mav = new ModelAndView("AddSkill");
		return mav;

	}

	@RequestMapping(path = "/searchMentor")
	public ModelAndView getMentorUserList(ModelMap map, @ModelAttribute("mentor") @Valid Mentor mentor,
			HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();

		ArrayList<Skills> skillList = userService.getSkillList();
		map.addAttribute("mentor", new Mentor());
		map.addAttribute("skillsList", skillList);
		List<Mentor> mentorList = mentorDao.findBySkills(mentor.getSkills());
		System.out.println(mentorList);

		List<ProposalRequest> pr = prDao.findByUserId((Long) session.getAttribute("name"));
		mv.addObject("proposeList", pr);
		mv.addObject("mentorList", mentorList);
		mv.setViewName("DisplayMentor");

		return mv;
	}

	@RequestMapping(path = "/searchAdminMentor")
	public ModelAndView getMentorList(ModelMap map, @ModelAttribute("mentor") @Valid Mentor mentor,
			HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();

		List<Mentor> mentorList = mentorDao.findBySkillsAndSlotTime(mentor.getSkills(), mentor.getSlotTime());
		System.out.println(mentorList);
		if (mentorList.isEmpty()) {
			mv.setViewName("NoMentor");
		} else {
			mv.addObject("mentorList", mentorList);
			mv.setViewName("AdminSearch");
		}

		return mv;
	}

	@RequestMapping(value = "/addSkill", method = RequestMethod.POST)
	public ModelAndView insertSkill(@ModelAttribute("skill") @Valid Skills skill, BindingResult result,
			HttpServletRequest request, ModelMap map) throws SQLException {
		ModelAndView mav = null;

		if (result.hasErrors()) {
			mav = new ModelAndView("AddSkill");
			return mav;
		}
		adminService.insertSkill(skill);
		ArrayList<Skills> skillList = userService.getSkillList();
		map.addAttribute("mentor", new Mentor());
		map.addAttribute("skillsList", skillList);
		System.out.println(skillList);
		mav = new ModelAndView("UserLandingPage");
		return mav;

	}

	@RequestMapping(value = "/proposeTraining")
	public ModelAndView proposeTraining(@RequestParam("id") long id, @RequestParam("userId") long userId,
			@ModelAttribute("mentor") @Valid Mentor mentor, ModelMap map) throws SQLException {
		ModelAndView mav = null;
		List<ProposalRequest> proposal = prDao.findByUserIdAndMentorId(id, userId);
		if (proposal.isEmpty()) {
			ProposalRequest pr = new ProposalRequest();
			pr.setMentorId(id);
			pr.setUserId(userId);
			pr.setStatus("Pending");
			/*
			 * pr.setStatus("approve"); pr.setTechnologyId(1);
			 */
			prDao.save(pr);
		} else {
			System.out.println("Empty");

		}
		ModelAndView mv = new ModelAndView();

		ArrayList<Skills> skillList = userService.getSkillList();
		map.addAttribute("mentor", new Mentor());
		map.addAttribute("skillsList", skillList);
		List<Mentor> mentorList = mentorDao.findBySkills(mentor.getSkills());
		mv.addObject("mentorList", mentorList);
		mv.setViewName("DisplayMentor");
		return mv;
	}
/*
	@RequestMapping(path = "/block")
	public ModelAndView blockUserList(ModelMap map, @RequestParam("userId") long userId, HttpServletRequest request,
			HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		User user = userDao.findByUserId(userId);
		Login login = loginDao.findByEmail(user.getEmail());
		login.setAccess(1);
		user.setAccess(1);
		userDao.save(user);
		loginDao.save(login);
		map.addAttribute("userList", userDao.findAll());
		mv.setViewName("UserList");
		return mv;
	}

	@RequestMapping(path = "/unblock")
	public ModelAndView unblockUserList(ModelMap map, @RequestParam("userId") long userId, HttpServletRequest request,
			HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();

		User user = userDao.findByUserId(userId);
		Login login = loginDao.findByEmail(user.getEmail());
		login.setAccess(0);
		loginDao.save(login);
		user.setAccess(0);
		userDao.save(user);
		map.addAttribute("userList", userDao.findAll());
		mv.setViewName("UserList");
		return mv;
	}
*/
	@RequestMapping("/updateSkill")
	public ModelAndView updateSkill(ModelMap map, @RequestParam("id") int skillId,
			@ModelAttribute("skill") Skills skills) throws SQLException {
		ModelAndView mav = null;
		skills = skillDao.getOne(skillId);

		map.addAttribute("skillList", skills);
		mav = new ModelAndView("UpdateSkill");
		return mav;

	}

	@PutMapping(value = "/skillUpdate")
	public Skills skillUpdate(@ModelAttribute("skill") Skills skill, BindingResult result, HttpServletRequest request,
			ModelMap map) throws SQLException {
		ModelAndView mav = null;

		Optional<Skills> skills = skillDao.findById((int) skill.getSkillId());

		if (skills.isPresent())

		{

			Skills s = skills.get();

			s.setSkillName(skill.getSkillName());
			s.setBaseAmount(skill.getSkillName());

			s = skillDao.save(s);
			return s;

		} else {
			skill = skillDao.save(skill);

			return skill;
		}

	}

	@RequestMapping("/userList")
	public ModelAndView userList(ModelMap map) throws SQLException {
		ModelAndView mav = null;

		map.addAttribute("userList", userDao.findAll());
		mav = new ModelAndView("UserList");
		return mav;

	}

	@RequestMapping("/skillList")
	public ModelAndView skillList(ModelMap map) throws SQLException {
		ModelAndView mav = null;

		map.addAttribute("skillList", skillDao.findAll());
		mav = new ModelAndView("SkillList");
		return mav;

	}

	@RequestMapping("/mentorList")
	public ModelAndView mentorList(ModelMap map) throws SQLException {
		ModelAndView mav = null;

		map.addAttribute("mentorList", mentorDao.findAll());
		mav = new ModelAndView("MentorList");
		return mav;

	}

}
