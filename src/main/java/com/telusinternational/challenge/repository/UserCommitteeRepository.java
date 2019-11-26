package com.telusinternational.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusinternational.challenge.model.User;
import com.telusinternational.challenge.model.UserCommittee;

@Repository
public interface UserCommitteeRepository extends JpaRepository <UserCommittee, Integer>{

	List<UserCommittee> findByAssignedUser(User user);
	
}
