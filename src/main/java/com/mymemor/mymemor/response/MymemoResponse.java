package com.mymemor.mymemor.response;

import java.util.List;

import com.mymemor.mymemor.model.Memory;

import lombok.Getter;
import lombok.Setter;

public class MymemoResponse {
	@Getter
	@Setter
	String status;
	@Getter
	@Setter
	String error;
	@Getter
	@Setter
	List<Memory> memories ;

}
