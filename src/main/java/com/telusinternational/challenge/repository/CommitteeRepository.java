package com.telusinternational.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusinternational.challenge.model.Committee;

@Repository
public interface CommitteeRepository extends JpaRepository < Committee, Integer > {

}
