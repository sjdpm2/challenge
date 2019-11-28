package com.telusinternational.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telusinternational.challenge.constants.Consts;
import com.telusinternational.challenge.service.CandidateService;
import com.telusinternational.challenge.service.CommitteeService;
import com.telusinternational.challenge.service.UserCommitteeService;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
	
	@Autowired
	private CandidateService caService;
	@Autowired
	private CommitteeService ctService;
	@Autowired
	private UserCommitteeService usCtService;
	
	@GetMapping("/{ctId}")
    public String candidate(@PathVariable Integer ctId, Model model) {
		if(usCtService.validateAvailabilityforUser(ctId, Consts.BY_COMMITTEE_ID))
		{
			model.addAttribute("candidates", caService.findAllByCommittee(ctId));
			model.addAttribute("committee", ctService.findById(ctId));
	        return "candidates";
		}
		else
		{
			return "redirect:/error";
		}
    }
}
