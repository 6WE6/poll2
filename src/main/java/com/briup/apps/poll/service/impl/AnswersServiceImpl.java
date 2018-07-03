package com.briup.apps.poll.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.AnswersExample;
import com.briup.apps.poll.bean.extend.AnswersVM;
import com.briup.apps.poll.dao.AnswersMapper;
import com.briup.apps.poll.dao.extend.AnswersVMMapper;
import com.briup.apps.poll.service.IAnswersService;

@Service
public class AnswersServiceImpl implements IAnswersService{
	@Autowired
	private AnswersMapper answersMapper;
	@Autowired
	private AnswersVMMapper answersVMMapper;
	
	/**
	 * 保存或更新答题卡信息
	 */
	@Override
	public void saveOrUpdateAnswers(Answers answers) throws Exception {
		// TODO Auto-generated method stub
		if(answers.getId()!=null) {
			//更新
			answersMapper.updateByPrimaryKey(answers);
		}else {
			//添加
			answersMapper.insert(answers);
		}
	}
	/**
	 * 通过id查询答题卡信息
	 */
	@Override
	public Answers findAnswersById(long id) throws Exception {
		// TODO Auto-generated method stub
		return answersMapper.selectByPrimaryKey(id);
	}	
	
	
	
	/**
	 * 通过课调id查询答题卡信息
	 */
	@Override
	public List<Answers> findAnswersByServeyId(long id) throws Exception {
		// TODO Auto-generated method stub
		AnswersExample example=new AnswersExample();
		example.createCriteria().andSurveyIdEqualTo(id);
		return answersMapper.selectByExample(example);

	}
	
	/**
	 * 按空模板查询所有答题卡信息(QBC查询)
	 */
	@Override
	public List<Answers> findAll() throws Exception {
		// TODO Auto-generated method stub
		AnswersExample example=new AnswersExample();		
		return answersMapper.selectByExample(example);
	}
	
	
	/**
	 * 通过关键字查询课程信息
	 */
	@Override
	public List<Answers> query(String keywords) throws Exception {
		AnswersExample example=new AnswersExample();
		example.createCriteria().andContentLike(keywords);
		return answersMapper.selectByExample(example);
	}

	@Override
	public List<Answers> findAnswersByKeyword(String Keywords) throws Exception {
		AnswersExample example=new AnswersExample();
		//添加条件：content属性中包含keywords关键字
		example.createCriteria().andContentEqualTo(Keywords);		
		return answersMapper.selectByExample(example);
	}

	
	
	/**
	 * 通过id删除答题卡信息
	 */
	@Override
	public void deleteAnswersById(long id) throws Exception {
		// TODO Auto-generated method stub
		answersMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 批量删除课程信息
	 */
	@Override
	public void bathDeleteAnswers(long[] ids) throws Exception {
		// TODO Auto-generated method stub
		for(long id:ids)
			answersMapper.deleteByPrimaryKey(id);
	}
	/*
	 * 查询所有答题卡，包括问卷
	 */
	@Override
	public List<AnswersVM> selectAllAnswersVM() throws Exception {
		// TODO Auto-generated method stub
		
		return answersVMMapper.selectAll();
	}

	

}
