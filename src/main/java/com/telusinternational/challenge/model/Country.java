package com.telusinternational.challenge.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "co_id")
    private Integer id;
    
    @Column(name = "co_name")
    private String name;
    

    @OneToMany(mappedBy="country")
    private List <User> users;
    
    @OneToMany(mappedBy="country")
    private List <Committee> committees;

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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Committee> getCommittees() {
		return committees;
	}

	public void setCommittees(List<Committee> committees) {
		this.committees = committees;
	}
	
	
    
}
