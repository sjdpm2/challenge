package com.telusinternational.challenge.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusinternational.challenge.model.Committee;
import com.telusinternational.challenge.repository.CommitteeRepository;
import com.telusinternational.challenge.service.CommitteeService;

@Service
public class CommitteeServiceImpl implements CommitteeService{
	@Autowired
	private CommitteeRepository ctRep;

	@Override
	public Committee findById(Integer ctId) {
		Optional<Committee> committee = ctRep.findById(ctId);
		return committee.get();
	}
	
	

}
