package com.telusinternational.challenge.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusinternational.challenge.model.User;
import com.telusinternational.challenge.model.UserCommittee;
import com.telusinternational.challenge.repository.UserCommitteeRepository;
import com.telusinternational.challenge.service.UserCommitteeService;

@Service
public class UserCommitteeServiceImpl implements UserCommitteeService{

	@Autowired
	private UserCommitteeRepository usCoRep;
	
	@Override
	public List<UserCommittee> getCommitteesVotedByUser(User user) {
		return usCoRep.findByAssignedUser(user);
	}

}
