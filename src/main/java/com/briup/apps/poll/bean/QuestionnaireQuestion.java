package com.briup.apps.poll.bean;
/**
 * POJO类    问卷-问题(桥表)
 * @author Jia
 *
 */
public class QuestionnaireQuestion {

    private Long id;
    private Long questionnaireId;
    private Long questionId;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getQuestionnaireId() {
        return questionnaireId;
    }
    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
    public Long getQuestionId() {
        return questionId;
    }
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}