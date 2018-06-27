package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.AnswersVM;

public interface IAnswersService {
	/*
	 * 查询所有答题卡，包括问卷
	 */
	List<AnswersVM> selectAllAnswersVM() throws Exception; 
	/*
	 * 查询所有答题卡
	 */
	List<Answers> findAll() throws Exception;

	/*
	 * 通过id查询答题卡
	 */
	Answers findAnswersById(long id) throws Exception;

	/*
	 * 通过关键字查询答题卡
	 */
	List<Answers> query(String keywords) throws Exception;
	
	List<Answers> findAnswersByKeyword(String Keywords) throws Exception;

	/*
	 * 保存或修改答题卡信息
	 */
	void saveOrUpdateAnswers(Answers answers) throws Exception;

	/*
	 * 通过id删除答题卡信息
	 */
	void deleteAnswersById(long id) throws Exception;

	/*
	 * 批量删除答题卡信息
	 */
	void bathDeleteAnswers(long[] ids) throws Exception;

	
}
