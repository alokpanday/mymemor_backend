package com.mymemor.mymemor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "memories")
public class Memory extends Auditable {

    @Getter
    @Setter
    @NotBlank
    private String topic;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private String location;

    @Getter
    @Setter
    @ElementCollection
    private Set<String> photos = new HashSet<>();

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Getter
    @Setter
    @NotNull
    @ManyToOne
    private User creator;

    public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<String> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<String> photos) {
		this.photos = photos;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Getter
    @Setter
    @ManyToMany
    private Set<User> users = new HashSet<>();

}