package com.telusinternational.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.telusinternational.challenge.service.UserCommitteeService;
import com.telusinternational.challenge.service.UserService;

@Controller
public class MainController {

	@Autowired
	UserCommitteeService usCoService;
	@Autowired
    private UserService userService;
	
    @GetMapping("/")
    public String root(Model model) {
    	model.addAttribute("committeesVoted", usCoService.getCommitteesVotedByUser(userService.getLoggedUser()));
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
}
