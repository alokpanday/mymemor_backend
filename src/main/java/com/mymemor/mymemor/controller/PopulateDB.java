package com.mymemor.mymemor.controller;

import com.mymemor.mymemor.Utils;
import com.mymemor.mymemor.model.Account;
import com.mymemor.mymemor.model.User;
import com.mymemor.mymemor.repository.AccountRepository;
import com.mymemor.mymemor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/dev")
public class PopulateDB {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/add-user")
    public void addDummyUser() throws IOException {
        userRepository.deleteAll();
        Account dummy = new Account();
        User luffy = new User();

        dummy.setEmail("xyz@gmail.com");
        dummy.setUsername("dummy");
        dummy.setEncPassword(Utils.encryptPassword("Dummy Password"));
        dummy.setUser(luffy);

//        luffy.setAccount(dummy);
        luffy.setName("Mokey D luffy");
        luffy.setProfilePicURL("https://i.imgur.com/kB7StJm.png");
        luffy.setSchoolName("xyxzz");
        luffy.setCurrentCity("Kolkata");
        luffy.setHometown("syzff");

//        userRepository.save(luffy);
        accountRepository.save(dummy);

    }

}

