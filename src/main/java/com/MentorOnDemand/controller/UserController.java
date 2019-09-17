package com.MentorOnDemand.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MentorOnDemand.model.Mentor;
import com.MentorOnDemand.model.ProposalRequest;
import com.MentorOnDemand.model.Skills;
import com.MentorOnDemand.repository.ProposeDao;
import com.MentorOnDemand.service.UserService;

@Controller
public class UserController {
	@Autowired
	ProposeDao propose;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/userNotification")
	public ModelAndView userNotificatons(ModelMap map) throws SQLException {
		ModelAndView mv = new ModelAndView();
		/* List<ProposalRequest> pr1 = propose.findAll(); */

		List<ProposalRequest> pr = propose.findAll();
		map.addAttribute("proposeList", pr);
		ArrayList<Skills> skillList = userService.getSkillList();
		map.addAttribute("skillsList", skillList);
		map.addAttribute("mentor", new Mentor());
		mv.setViewName("UserNotificationList");

		return mv;
	}
}
