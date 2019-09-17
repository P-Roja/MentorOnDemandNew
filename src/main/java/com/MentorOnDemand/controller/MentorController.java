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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.MentorOnDemand.repository.LoginDao;
import com.MentorOnDemand.repository.MentorDao;
import com.MentorOnDemand.repository.ProposeDao;
import com.MentorOnDemand.repository.TrainingDao;
import com.MentorOnDemand.repository.UserDao;
import com.MentorOnDemand.model.Login;
import com.MentorOnDemand.model.Mentor;
import com.MentorOnDemand.model.ProposalRequest;
import com.MentorOnDemand.model.Skills;
import com.MentorOnDemand.model.Trainings;
import com.MentorOnDemand.model.User;

@Controller
public class MentorController {
	@Autowired
	ProposeDao prDao;
	@Autowired
	MentorDao mentorDao;
	@Autowired
	LoginDao loginDao;
	@Autowired
	ProposeDao proposeDao;
	@Autowired
	TrainingDao trainingDao;

	@RequestMapping(value = "/notification")
	public ModelAndView notificatons(ModelMap map) throws SQLException {
		ModelAndView mv = new ModelAndView();
		List<ProposalRequest> proposal = prDao.findAll();

		map.addAttribute("notificationList", proposal);

		mv.setViewName("ProposalList");
		return mv;
	}

	@RequestMapping(value = "/acceptTraining")
	public ModelAndView acceptTraining(@RequestParam("userId") long userId, @RequestParam("mentorId") long mentorId,
			@RequestParam("proposeId") long proposeId, ModelMap map) throws SQLException {

		ProposalRequest pr = proposeDao.findByProposalId(proposeId);
		pr.setStatus("Approved");
		proposeDao.save(pr);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MentorLandingPage");

		return mv;
	}

	@RequestMapping(value = "/rejectTraining")
	public ModelAndView rejectTraining(@RequestParam("userId") long userId, @RequestParam("mentorId") long mentorId,
			@RequestParam("proposeId") long proposeId, ModelMap map) throws SQLException {

		ProposalRequest pr = proposeDao.findByProposalId(proposeId);
		proposeDao.delete(pr);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MentorLandingPage");

		return mv;
	}

	@RequestMapping(path = "/mentorblock")
	public ModelAndView blockUserList(ModelMap map, @RequestParam("userId") long userId, HttpServletRequest request,
			HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		Mentor mentor = mentorDao.findByMentorId(userId);
		Login login = loginDao.findByEmail(mentor.getEmail());
		login.setAccess(1);
		mentor.setAccess(1);
		mentorDao.save(mentor);
		loginDao.save(login);
		map.addAttribute("mentorList", mentorDao.findAll());
		mv.setViewName("MentorList");
		return mv;
	}

	@RequestMapping(path = "/mentorunblock")
	public ModelAndView unblockUserList(ModelMap map, @RequestParam("userId") long userId, HttpServletRequest request,
			HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();

		Mentor mentor = mentorDao.findByMentorId(userId);
		Login login = loginDao.findByEmail(mentor.getEmail());
		login.setAccess(0);
		mentor.setAccess(0);
		mentorDao.save(mentor);
		loginDao.save(login);
		map.addAttribute("mentorList", mentorDao.findAll());
		mv.setViewName("MentorList");
		return mv;
	}

	@RequestMapping("/updateTraininigs")
	public ModelAndView updateTrainings(@ModelAttribute("trainings") @Valid Trainings training, BindingResult result,
			HttpServletRequest request, ModelMap map) throws SQLException {
		ModelAndView mav = null;

		if (result.hasErrors()) {
			mav = new ModelAndView("AddSkill");
			return mav;
		}
		trainingDao.save(training);

		mav = new ModelAndView("MentorLandingPage");
		return mav;

	}
}
