package com.mymemor.mymemor.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mymemor.mymemor.model.Memory;
 


public interface MemoryRepository  extends JpaRepository<Memory, Long>  {
	 

}
