package com.telusinternational.challenge.service;

import java.util.List;

import com.telusinternational.challenge.model.Committee;
import com.telusinternational.challenge.model.User;
import com.telusinternational.challenge.model.UserCommittee;


public interface UserCommitteeService {
	
	List <UserCommittee> getCommitteesVotedByUser(User user);
	
	List<Committee> findAllByUserCountryAndNotVoted(Long userId, Integer countryId);
	
	Boolean vote(Integer caId);
	
	Boolean committeAvailableforUser(Integer id, Integer type);
}
