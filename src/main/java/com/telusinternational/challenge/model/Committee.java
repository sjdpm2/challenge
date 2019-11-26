package com.telusinternational.challenge.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Committee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ct_id")
    private Integer id;
	
	@Column(name = "ct_name")
    private String name;
    
	@ManyToOne
    @JoinColumn(name="ct_co_id", nullable=false)
    private Country country;
	
	@OneToMany(mappedBy="committee")
    private List <Candidate> candidates;
	
	@OneToMany(mappedBy="assignedCommittee")
    private List <UserCommittee> userCommittees;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public List<UserCommittee> getUserCommittees() {
		return userCommittees;
	}

	public void setUserCommittees(List<UserCommittee> userCommittees) {
		this.userCommittees = userCommittees;
	}
	
	
	
}
