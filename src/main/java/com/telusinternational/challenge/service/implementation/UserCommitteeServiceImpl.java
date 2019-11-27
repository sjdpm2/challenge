package com.telusinternational.challenge.service.implementation;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusinternational.challenge.model.Candidate;
import com.telusinternational.challenge.model.Committee;
import com.telusinternational.challenge.model.User;
import com.telusinternational.challenge.model.UserCommittee;
import com.telusinternational.challenge.repository.CandidateRepository;
import com.telusinternational.challenge.repository.CommitteeRepository;
import com.telusinternational.challenge.repository.UserCommitteeRepository;
import com.telusinternational.challenge.service.UserCommitteeService;
import com.telusinternational.challenge.service.UserService;

@Service
public class UserCommitteeServiceImpl implements UserCommitteeService{

	@Autowired
	private UserCommitteeRepository usCtRep;
	@Autowired
	private CommitteeRepository comRep;
	@Autowired
	private CandidateRepository caRep;
	@Autowired
	private UserService usService;
	
	@Override
	public List<UserCommittee> getCommitteesVotedByUser(User user) {
		return usCtRep.findByAssignedUser(user);
	}

	@Override
	public List<Committee> findAllByUserCountryAndNotVoted(Long userId, Integer countryId) {
		return comRep.findAllByUserCountryAndNotVoted(userId, countryId);
	}

	@Override
	public Boolean vote(Integer caId) {
		Optional<Candidate> candidate = caRep.findById(caId);
		User loggedUser = usService.getLoggedUser();
		
		//Adding committee per user
		UserCommittee userCommittee = new UserCommittee();
		userCommittee.setAssignedCommittee(candidate.get().getCommittee());
		userCommittee.setAssignedUser(loggedUser);
		userCommittee.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		usCtRep.save(userCommittee);
		
		//Adding vote
		Integer votes = candidate.get().getVotes();
		votes = votes + 1;
		candidate.get().setVotes(votes);
		caRep.save(candidate.get());
		
		return true;
	}

}
