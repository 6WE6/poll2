package com.briup.apps.poll.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * POJO类    课调
 * @author yun
 */
@ApiModel(value="课调")
public class Survey {


	@ApiModelProperty(value="主键自增策略")
    private Long id;

	@ApiModelProperty(value="课调的状态，1为未开始，2为进行中，3为结束")
    private String status;

	@ApiModelProperty(value="")
    private String code;

	@ApiModelProperty(value="课调的日期，类型为sting")
    private String surveydate;

	@ApiModelProperty(value="课调的课程id，外键关联")
    private Long courseId;

	@ApiModelProperty(value="课调班级id，外键关联")
    private Long clazzId;

	@ApiModelProperty(value="课调对象老师id，外键关联")
    private Long userId;

	@ApiModelProperty(value="问卷id")
    private Long questionnaireId;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getSurveydate() {
        return surveydate;
    }

    public void setSurveydate(String surveydate) {
        this.surveydate = surveydate == null ? null : surveydate.trim();
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getClazzId() {
        return clazzId;
    }

    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }
}