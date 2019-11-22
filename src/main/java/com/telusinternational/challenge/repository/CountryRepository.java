package com.telusinternational.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusinternational.challenge.model.Country;

@Repository
public interface CountryRepository extends JpaRepository < Country, Integer > {

}
