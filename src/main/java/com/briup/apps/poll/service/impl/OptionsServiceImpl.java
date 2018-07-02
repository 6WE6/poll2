package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.OptionsExample;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.service.IOptionsService;

@Service
public class OptionsServiceImpl implements IOptionsService{

	@Autowired
	private OptionsMapper optionsMapper;
	
	
	@Override
	public List<Options> findAllOptions() throws Exception {
		OptionsExample example = new OptionsExample();
		return optionsMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdateOptions(Options options) throws Exception {
		if(options.getId() != null){
			optionsMapper.updateByPrimaryKey(options);
		}else{
			optionsMapper.insert(options);
		}	
	}

	@Override
	public void deleteOptionsById(long id) throws Exception {
		optionsMapper.deleteByPrimaryKey(id);
		
	}
	

}
