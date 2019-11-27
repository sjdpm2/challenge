package com.telusinternational.challenge.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusinternational.challenge.dto.builder.CandidateDTOBuilder;
import com.telusinternational.challenge.model.Candidate;
import com.telusinternational.challenge.service.CandidateService;

@RestController
@RequestMapping("/api/report")
public class ReportController {
	
	@Autowired
	private CandidateService caService;
	@Autowired
	private CandidateDTOBuilder caDTOBld;
		
	@GetMapping("/candidates")
    public List<?> getCandidatesStats() {
		List<Candidate> candidates = caService.findAll();
		return caDTOBld.building(candidates);
    }
}
