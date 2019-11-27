package com.telusinternational.challenge.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "de_id")
    private Integer id;
	
	@Column(name = "de_name")
    private String name;
	
	@OneToMany(mappedBy="department")
    private List <Candidate> candidates;

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
	
	
}
