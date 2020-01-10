package com.mymemor.mymemor.repository;

import com.mymemor.mymemor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
