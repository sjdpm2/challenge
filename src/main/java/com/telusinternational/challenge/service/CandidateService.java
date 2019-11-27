package com.telusinternational.challenge.service;

import java.util.List;

import com.telusinternational.challenge.model.Candidate;

public interface CandidateService {
	
	List<Candidate> findAllByCommittee(Integer ctId);
    
	List<Candidate> findAll();
}
