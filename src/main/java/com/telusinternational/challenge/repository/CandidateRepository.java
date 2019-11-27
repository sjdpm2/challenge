package com.telusinternational.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusinternational.challenge.model.Candidate;
import com.telusinternational.challenge.model.Committee;

@Repository
public interface CandidateRepository extends JpaRepository < Candidate, Integer > {
	
	List<Candidate> findAllByCommittee(Committee commitee);

}
