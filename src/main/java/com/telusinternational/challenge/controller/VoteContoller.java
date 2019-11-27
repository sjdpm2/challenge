package com.telusinternational.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telusinternational.challenge.service.UserCommitteeService;

@Controller
@RequestMapping("/vote")
public class VoteContoller {
@Autowired
private UserCommitteeService usCtService;
	
	@GetMapping("/{caId}")
    public String candidate(@PathVariable Integer caId) {
		if(usCtService.committeAvailableforUser(caId, 2))
		{
			usCtService.vote(caId);
			return "redirect:/";
		}
		else
		{
			return "redirect:/error";
		}
    }
}
