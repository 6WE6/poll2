package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Options;

public interface IOptionsService {
	List<Options> findAllOptions() throws Exception;
	
	void saveOrUpdateOptions(Options options) throws Exception;
	
	void deleteOptionsById(long id) throws Exception;
	
	

}
