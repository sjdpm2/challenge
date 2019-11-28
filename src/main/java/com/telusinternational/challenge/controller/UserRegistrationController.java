package com.telusinternational.challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telusinternational.challenge.dto.UserRegistrationDTO;
import com.telusinternational.challenge.model.User;
import com.telusinternational.challenge.service.CountryService;
import com.telusinternational.challenge.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private CountryService countryService;

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDto() {
        return new UserRegistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
    	model.addAttribute("countries", countryService.getAllCountries());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDTO userDto,
        BindingResult result, Model model) {
        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
        	model.addAttribute("countries", countryService.getAllCountries());
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/registration?success";
    }
}
