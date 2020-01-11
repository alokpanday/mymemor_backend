package com.mymemor.mymemor.repository;
 
import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymemor.mymemor.exception.InvalidAction;
import com.mymemor.mymemor.model.Account;
 
 

public interface AccountRepository extends JpaRepository<Account, Long> 
{
 

	Account findByUsername(@Valid String username);
	 
	 
}