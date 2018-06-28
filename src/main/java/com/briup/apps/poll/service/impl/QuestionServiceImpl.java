package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.QuestionExample;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionVMMapper;
import com.briup.apps.poll.service.IQuestionService;
import com.mysql.jdbc.StringUtils;

/**
 * 业务逻辑接口实现  问题
 * @author wanglinhao
 *
 */

@Service
public class QuestionServiceImpl implements IQuestionService {
	
	@Autowired
	private QuestionMapper questionMapper;
	@Autowired
	private QuestionVMMapper questionVMMapper;
	@Autowired
	private OptionsMapper optionsMapper;
	
	/**
	 * 查询全部问题信息，包括关联的选项
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		return questionVMMapper.selectAllQuestionVM();
	}

	/**
	 * 通过id查询问题信息，包括关联的选项
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public QuestionVM findQuestionVMById(long id) throws Exception {
		return questionVMMapper.selectQuestionVMById(id);
	}
	
	/**
	 * 保存或修改问题信息，包括关联的选项
	 * @param questionVM
	 * @throws Exception
	 */
	@Override
	public void saveOrUpdataQuestionVM(QuestionVM questionVM) throws Exception {
		if (questionVM.getId() != null) {  // 不为空执行修改操作
			questionVMMapper.update(questionVM);
			optionsMapper.deleteByQid(questionVM.getId());
			for (Options options:questionVM.getOptions()) {
				options.setQuestionId(questionVM.getId());
				optionsMapper.insert(options);
			}
		} else {  // 执行新增操作
			questionVMMapper.insert(questionVM);
			for (Options options:questionVM.getOptions()) {
				options.setQuestionId(questionVM.getId());
				optionsMapper.insert(options);
			}
		}
	}
	
	/**
	 * 通过id删除问题信息，包括关联的选项
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void deleteQuestionVMById(long id) throws Exception {
		questionVMMapper.deleteById(id);
		optionsMapper.deleteByQid(id);
	}

	/**
	 * 批量删除问题信息，包括关联的选项
	 * @param ids
	 * @throws Exception
	 */
	@Override
	public void batchDeleteQuestionVM(long[] ids) throws Exception {
		for(long id:ids) {
			System.out.println(id);
			optionsMapper.deleteByQid(id);
			questionMapper.deleteByPrimaryKey(id);
		}
	}

	/**
	 * 查询所有的问题
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Question> findAllQuestion() throws Exception {
		QuestionExample example = new QuestionExample();
		return questionMapper.selectByExample(example);
	}

	/**
	 * 通过id查询问题
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Question findQuestionById(long id) throws Exception {
		return questionMapper.selectByPrimaryKey(id);
	}

	/**
	 * 通过关键字查询问题
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Question> findQuestionByKeyword(String keywords) throws Exception {
		QuestionExample example = new QuestionExample();
		example.createCriteria().andNameLike(keywords).andQuestiontypeLike(keywords);
		return questionMapper.selectByExample(example);
	}

	/**
	 * 保存或修改问题信息
	 * @param question
	 * @throws Exception
	 */
	@Override
	public void saveOrUpdataQuestion(Question question) throws Exception {
		if (question.getId() != null) {
			questionMapper.updateByPrimaryKey(question);
		} else {
			questionMapper.insert(question);
		}
	}

	/**
	 * 通过id删除问题信息
	 * @param id
	 * @throws Exception
	 */
	@Override
	public void deleteQuestionById(long id) throws Exception {
		questionMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 批量删除问题信息
	 * @param ids
	 * @throws Exception
	 */
	@Override
	public void batchDeleteQuestion(long[] ids) throws Exception {
		for(long id:ids) {
			questionMapper.deleteByPrimaryKey(id);
		}
	}

}
