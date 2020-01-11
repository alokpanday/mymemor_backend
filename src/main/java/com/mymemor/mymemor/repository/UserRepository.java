package com.mymemor.mymemor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.mymemor.mymemor.model.User;

public interface UserRepository extends JpaRepository<User, Long>  {
	 

}
