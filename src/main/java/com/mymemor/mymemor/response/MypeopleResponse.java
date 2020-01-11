package com.mymemor.mymemor.response;

import java.util.List;

import com.mymemor.mymemor.model.BondRequest;
import com.mymemor.mymemor.model.User;

import lombok.Getter;
import lombok.Setter;

public class MypeopleResponse {
	@Getter
	@Setter
	User user;
	
	@Getter
	@Setter
	List<BondRequest> recieverequest;

}
