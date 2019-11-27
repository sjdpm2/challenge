package com.telusinternational.challenge.model;

import javax.persistence.*;

@Entity
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ca_id")
    private Integer id;
	
	@Column(name = "ca_first_name")
    private String firstName;
    
    @Column(name = "ca_last_name")
    private String lastName;
    
    @Column(name = "ca_email")
    private String email;
    
    @Column(name = "ca_id_document")
    private String idDocument;
    
    @Column(name = "ca_votes")
    private Integer votes;
    
    @ManyToOne
    @JoinColumn(name="ca_de_id", nullable=false)
    private Department department;
    
    @ManyToOne
    @JoinColumn(name="ca_ct_id", nullable=false)
    private Committee committee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public Committee getCommittee() {
		return committee;
	}

	public void setCommittee(Committee committee) {
		this.committee = committee;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(String idDocument) {
		this.idDocument = idDocument;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
