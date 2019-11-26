package com.telusinternational.challenge.service;

import java.util.List;

import com.telusinternational.challenge.model.User;
import com.telusinternational.challenge.model.UserCommittee;


public interface UserCommitteeService {
	
	List <UserCommittee> getCommitteesVotedByUser(User user);
}
