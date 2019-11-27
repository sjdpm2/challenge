package com.telusinternational.challenge.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusinternational.challenge.model.Candidate;
import com.telusinternational.challenge.model.Committee;
import com.telusinternational.challenge.repository.CandidateRepository;
import com.telusinternational.challenge.repository.CommitteeRepository;
import com.telusinternational.challenge.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService{
	@Autowired
	private CandidateRepository caRep;
	@Autowired
	private CommitteeRepository ctRep;
	
	@Override
	public List<Candidate> findAllByCommittee(Integer ctId) {
		Optional<Committee> committee = ctRep.findById(ctId);
		return caRep.findAllByCommittee(committee.get());
	}

	@Override
	public List<Candidate> findAll() {
		return caRep.findAll();
	}

}
