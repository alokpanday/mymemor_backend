package com.mymemor.mymemor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
 
@SuppressWarnings("serial")
@Entity
@Table(name = "accounts")
public class Account extends Auditable {

    @Getter
    @Setter
    @NotBlank 
    @Email
    @Column(unique = true)
    private String email;

    @Getter
    @Setter
    @NotBlank
    @Column(unique = true)
     private String username;

    @Getter
    @Setter
    @NotBlank
    private String encPassword;

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEncPassword() {
		return encPassword;
	}

	public void setEncPassword(String encPassword) {
		this.encPassword = encPassword;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Getter
    @Setter
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
	  private User user;
}
