package com.telusinternational.challenge.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusinternational.challenge.model.Country;
import com.telusinternational.challenge.repository.CountryRepository;
import com.telusinternational.challenge.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryRepository couRep;

	@Override
	public List<Country> getAllCountries() {
		return couRep.findAll();
	}

	
}
