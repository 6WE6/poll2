package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.QuestionVM;

/**
 * 数据访问中间层 问题
 * @author wanglinhao
 *
 */

public interface QuestionVMMapper {
	
	/**
	 * 查询全部问题信息，包括关联的选项
	 * @return
	 */
	List<QuestionVM> selectAllQuestionVM();
	
	/**
	 * 通过id查询问题信息，包括关联的选项
	 * @param id
	 * @return
	 */
	QuestionVM selectQuestionVMById(long id);
	
	/**
	 * 新增问题
	 * @param questionVM
	 */
	void insert(QuestionVM questionVM);
	
	/**
	 * 修改信息
	 * @param questionVM
	 */
	void update(QuestionVM questionVM);
	
	/**
	 * 通过id删除
	 * @param id
	 */
	void deleteById(long id);

}
