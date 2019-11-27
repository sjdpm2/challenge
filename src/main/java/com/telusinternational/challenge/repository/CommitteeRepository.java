package com.telusinternational.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusinternational.challenge.model.Committee;

@Repository
public interface CommitteeRepository extends JpaRepository < Committee, Integer > {
	
	@Query(value = "SELECT c.* " +
			  "FROM committee c " +
			  "LEFT JOIN user_committee uc ON c.ct_id = uc.uc_ct_id AND uc.uc_us_id = ?1 " +
			  "WHERE  c.ct_co_id = ?2 " +
			  "AND uc.uc_id IS NULL",
			 nativeQuery = true)
	List<Committee> findAllByUserCountryAndNotVoted(Long userId, Integer countryId);

}
