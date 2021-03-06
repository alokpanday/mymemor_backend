package com.mymemor.mymemor.controller;
 import com.mymemor.mymemor.response.MymemoResponse;
import com.mymemor.mymemor.response.MypeopleResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 

import com.mymemor.mymemor.model.BondRequest;
import com.mymemor.mymemor.model.BondRequestStatus;
import com.mymemor.mymemor.model.Memory;
import com.mymemor.mymemor.model.User;
import com.mymemor.mymemor.repository.BondRequestRepository;
import com.mymemor.mymemor.repository.MemoryRepository;
import com.mymemor.mymemor.repository.UserRepository;
 

@RestController
 
public class MemoryendApi {
	 
	@Autowired
	private MemoryRepository memoryRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private  BondRequestRepository bondRequestRepo  ;
	
	@Autowired
	private MemoryRepository MemoryRepo;
	
	   @PostMapping("/addmemory")
	  public String addmemory (@Valid Memory memory)
		{
			 memoryRepo.save(memory); 
			  memory.setCreator(session.user );
			  session.user.getCreatedMemories().add(memory);
			  session.user.setCreatedMemories(creator.getCreatedMemories());
			  Set<User>users=memory.getUsers();
			  for(User user:users)
			 {
				 
				 user.getMemories().add(memory);
				 user.setMemories(user.getMemories() );
			 }
			  memoryRepo.save(memory); 
			 return "memory has neen added";
		 }
	   
	   @GetMapping("/mypeople(session)")
		  public MypeopleResponse mypeople ()
			{ 
		   MypeopleResponse mypeopleresponse =new  MypeopleResponse();
		   mypeopleresponse.setUser(session);
		   List<BondRequest> recieverequest=session.getRecieveRequest();
		   mypeopleresponse.setRecieveRequest(recieverequest);
		   return mypeopleresponse;
			}
	  
	   
	   @PostMapping("/sendrequest")
		  public void sendrequest (@RequestParam("username") @Valid String username)
			{
				 User user=userRepo.findById(userId).orElseThrow();
				 
				 BondRequest br=new BondRequest();
				// br.setFrom(this);
				 br.setTo(user);
				 user.getReceivedRequests().add(br);
			   user.setReceivedRequests(user.getReceivedRequests());
			   
			   bondRequestRepo.save(br);
				return  ;
			}
	   

	   @GetMapping("/acceptrequest/{brid}")
		  public void acceptrequest (@PathVariable(value = "brid") Long BondRequestId)
			{ 
		   BondRequest br =bondRequestRepo.findById(BondRequestId).orElseThrow();
		   User to=br.getTo();User from=br.getFrom();
		   br.setBondRequestStatus(br.getBondRequestStatus().ACCEPTED);
		   
				return ;
			}
	   
	   @GetMapping("/memoline/{sortby}")
		  public MymemoResponse memoline(@PathVariable(value = "sortby") String type)
			{ 
		   MymemoResponse myMemoResponse;
		   myMemoResponse.setStatus("success");
		   List<Memory>memoline; 
		   List<Memory>memories=new ArrayList<>();
		   try {
		        if(type=="create_time") {
		        	
                  memories.addAll(memoryRepo.findAllByOrderByCreate_TimeAsc());
                 
		        }
		        else
		        {
		        	  memories.addAll(memoryRepo.findAllByOrderByMemory_TimeAsc());
		         }
		   }
		   catch(Exception e)
		   {
			   myMemoResponse.setStatus("error"); 
			   myMemoResponse.setError("not found memory");
			   return myMemoResponse;
		   }
		        
		        for(Memory memory:memories)
                {
              	 if(memory.getCreator().equals("/session") 
              			 {
              		 memoline.add(memory);
              			 }
              	 else
              	 {
              		 Set<User>users=memory.getUsers();
              		 for(User user:users)
              		 {
              			 if(user.equals("//session")
              					 {
              				 memoline.add(memory);
              					 }
              		 }
              		 
              	 }
                }
		        myMemoResponse.setMemories(memoline);
                return myMemoResponse; ;
                  
			}
 
}
