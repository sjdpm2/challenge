package com.telusinternational.challenge.dto.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.telusinternational.challenge.dto.CandidateDTO;
import com.telusinternational.challenge.model.Candidate;


@Component
public class CandidateDTOBuilder {
	
	public List<CandidateDTO> building(List<Candidate> candidates)
	{
		List<CandidateDTO> candidatesFormated = new ArrayList<CandidateDTO>();
		for(Candidate c: candidates)
		{
			CandidateDTO candidateDTO = new CandidateDTO();
			candidateDTO.setFirstName(c.getFirstName());
			candidateDTO.setLastName(c.getLastName());
			candidateDTO.setCommittee(c.getCommittee().getName());
			candidateDTO.setCountry(c.getCommittee().getCountry().getName());
			candidateDTO.setDepartment(c.getDepartment().getName());
			candidateDTO.setEmail(c.getEmail());
			candidateDTO.setIdDocument(c.getIdDocument());
			candidateDTO.setVotes(c.getVotes());
			candidatesFormated.add(candidateDTO);
		}
		return candidatesFormated;
	}
}
