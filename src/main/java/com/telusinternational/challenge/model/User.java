package com.telusinternational.challenge.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "us_email"))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id")
    private Long id;
    
    @Column(name = "us_first_name")
    private String firstName;
    
    @Column(name = "us_last_name")
    private String lastName;
    
    @Column(name = "us_email")
    private String email;
    
    @Column(name = "us_password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(
            name = "ur_us_id", referencedColumnName = "us_id"),
        inverseJoinColumns = @JoinColumn(
            name = "ur_ro_id", referencedColumnName = "ro_id"))
    private Collection < Role > roles;

    @ManyToOne
    @JoinColumn(name="us_co_id", nullable=false)
    private Country country;
    
    @OneToMany(mappedBy="assignedUser")
    private List <UserCommittee> userCommittees;
    
    public User() {}

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String password, Collection < Role > roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection < Role > getRoles() {
        return roles;
    }

    public void setRoles(Collection < Role > roles) {
        this.roles = roles;
    }

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
    public List<UserCommittee> getUserCommittees() {
		return userCommittees;
	}

	public void setUserCommittees(List<UserCommittee> userCommittees) {
		this.userCommittees = userCommittees;
	}

	@Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + "*********" + '\'' +
            ", roles=" + roles +
            '}';
    }
    
    
}
