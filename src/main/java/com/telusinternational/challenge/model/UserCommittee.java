package com.telusinternational.challenge.model;

import javax.persistence.*;

@Entity
public class UserCommittee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uc_id")
    private Integer id;
	
	@ManyToOne
    @JoinColumn(name="uc_ct_id", nullable=false)
    private Committee assignedCommittee;
	
	@ManyToOne
    @JoinColumn(name="uc_us_id", nullable=false)
    private User assignedUser;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Committee getAssignedCommittee() {
		return assignedCommittee;
	}

	public void setAssignedCommittee(Committee assignedCommittee) {
		this.assignedCommittee = assignedCommittee;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}
	
	
	
}
