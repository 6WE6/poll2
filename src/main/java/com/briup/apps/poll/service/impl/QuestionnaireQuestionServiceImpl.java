package com.briup.apps.poll.service.impl;

import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.dao.QuestionnaireQuestionMapper;
import com.briup.apps.poll.service.QuestionnaireQuestionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author JiaQi
 *
 * QuestionnaireQuestion 业务实现类
 *
 * 使用事务注解 出错回滚
 */
@Service
@Transactional
public class QuestionnaireQuestionServiceImpl implements QuestionnaireQuestionService{

    @Resource
    private QuestionnaireQuestionMapper questionnaireQuestionMapper;//mapper

    @Override
    public long countByExample(QuestionnaireQuestionExample example) {
        return questionnaireQuestionMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(QuestionnaireQuestionExample example) {
        return questionnaireQuestionMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return questionnaireQuestionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(QuestionnaireQuestion record) {
        return questionnaireQuestionMapper.insert(record);
    }

    @Override
    public int insertSelective(QuestionnaireQuestion record) {
        return questionnaireQuestionMapper.insertSelective(record);
    }

    @Override
    public List<QuestionnaireQuestion> selectByExample(QuestionnaireQuestionExample example) {
        return questionnaireQuestionMapper.selectByExample(example);
    }

    @Override
    public QuestionnaireQuestion selectByPrimaryKey(Long id) {
        return questionnaireQuestionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(QuestionnaireQuestion record, QuestionnaireQuestionExample example) {
        return questionnaireQuestionMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(QuestionnaireQuestion record, QuestionnaireQuestionExample example) {
        return questionnaireQuestionMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(QuestionnaireQuestion record) {
        return questionnaireQuestionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(QuestionnaireQuestion record) {
        return questionnaireQuestionMapper.updateByPrimaryKey(record);
    }
}