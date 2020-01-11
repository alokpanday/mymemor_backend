package com.mymemor.mymemor.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
 
 

@SuppressWarnings("serial")
@Entity
@Table(name = "users")
 
public class User extends Auditable {

    @Getter
    @Setter
    @NotNull
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;

    @Getter
    @Setter
    @NotBlank
    private String name;

    @Getter
    @Setter
    @URL
    @NotBlank
    private String profilePicURL;

    public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfilePicURL() {
		return profilePicURL;
	}

	public void setProfilePicURL(String profilePicURL) {
		this.profilePicURL = profilePicURL;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public List<Memory> getCreatedMemories() {
		return createdMemories;
	}

	public void setCreatedMemories(List<Memory> createdMemories) {
		this.createdMemories = createdMemories;
	}

	public List<Memory> getMemories() {
		return memories;
	}

	public void setMemories(List<Memory> memories) {
		this.memories = memories;
	}

	public List<BondRequest> getSentRequests() {
		return sentRequests;
	}

	public void setSentRequests(List<BondRequest> sentRequests) {
		this.sentRequests = sentRequests;
	}

	public List<BondRequest> getReceivedRequests() {
		return receivedRequests;
	}

	public void setReceivedRequests(List<BondRequest> receivedRequests) {
		this.receivedRequests = receivedRequests;
	}

	public Set<User> getMyPeople() {
		return myPeople;
	}

	public void setMyPeople(Set<User> myPeople) {
		this.myPeople = myPeople;
	}

	@Getter
    @Setter
    private String schoolName;
	
	@Getter
    @Setter
    private String collegeName;

    public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Getter
    @Setter
    private String currentCity;

    @Getter
    @Setter
    private String hometown;

    @Getter
    @Setter
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Memory> createdMemories = new ArrayList<>();

    @Getter
    @Setter
    @ManyToMany(mappedBy = "users")
    private List<Memory> memories = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(mappedBy = "from")
    private List<BondRequest> sentRequests = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(mappedBy = "to")
    private List<BondRequest> receivedRequests = new ArrayList<>();

    @Getter
    @Setter
    @ManyToMany
    private Set<User> myPeople = new HashSet<>();
}