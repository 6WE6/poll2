package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;

/**
 * 业务逻辑处理接口  问题
 * @author wanglinhao
 *
 */
public interface IQuestionService {
	
	/**
	 * 查询全部问题信息，包括关联的选项
	 * @return
	 * @throws Exception
	 */
	List<QuestionVM> findAllQuestionVM() throws Exception;
	
	/**
	 * 通过id查询问题信息，包括关联的选项
	 * @param id
	 * @return
	 * @throws Exception
	 */
	QuestionVM findQuestionVMById(long id) throws Exception;
	
	/**
	 * 通过关键字模糊查询，包括关联的选项,关键字的索引列有 QuestionVM.name（问题的标题）和 Options.name（选项的内容）
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	List<QuestionVM> findQuestionVMByKeyword(String keyword) throws Exception;
	
	/**
	 * 保存或修改问题信息，包括关联的选项
	 * @param questionVM
	 * @throws Exception
	 */
	void saveOrUpdataQuestionVM(QuestionVM questionVM) throws Exception;

	/**
	 * 通过id删除问题信息，包括关联的选项
	 * @param id
	 * @throws Exception
	 */
	void deleteQuestionVMById(long id) throws Exception;
	
	/**
	 * 批量删除问题信息，包括关联的选项
	 * @param ids
	 * @throws Exception
	 */
	void batchDeleteQuestionVM(long[] ids) throws Exception;
	
	/**
	 * 查询所有的问题
	 * @return
	 * @throws Exception
	 */
	List<Question> findAllQuestion() throws Exception;
	
	/**
	 * 通过id查询问题
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Question findQuestionById(long id) throws Exception;
	
	/**
	 * 通过关键字查询问题
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	List<Question> findQuestionByKeyword(String keywords) throws Exception;
	
	/**
	 * 保存或修改问题信息
	 * @param question
	 * @throws Exception
	 */
	void saveOrUpdataQuestion(Question question) throws Exception;
	
	/**
	 * 通过id删除问题信息
	 * @param id
	 * @throws Exception
	 */
	void deleteQuestionById(long id) throws Exception;
	
	/**
	 * 批量删除问题信息
	 * @param ids
	 * @throws Exception
	 */
	void batchDeleteQuestion(long[] ids) throws Exception;
	
}
