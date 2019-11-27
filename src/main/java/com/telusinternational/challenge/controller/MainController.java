package com.telusinternational.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.telusinternational.challenge.model.User;
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
    	User loggedUser = userService.getLoggedUser();
    	model.addAttribute("committeesVoted", usCoService.getCommitteesVotedByUser(loggedUser));
    	model.addAttribute("committeesPending", usCoService.findAllByUserCountryAndNotVoted(loggedUser.getId(), loggedUser.getCountry().getId()));
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
    
    @GetMapping("/error")
    public String error() {
        return "error";
    }
}
