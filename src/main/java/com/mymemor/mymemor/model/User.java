package com.mymemor.mymemor.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Getter
    @Setter
    private String schoolName;

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