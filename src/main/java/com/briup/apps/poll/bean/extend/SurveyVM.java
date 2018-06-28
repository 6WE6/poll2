package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * POJO类    课调
 * @author yun
 */
@ApiModel(value="课调")
public class SurveyVM {

	@ApiModelProperty(value="课调")
	private Survey survey;

	@ApiModelProperty(value="课调的课程")
    private Course course;

	@ApiModelProperty(value="课调的班级")
    private Clazz clazz;

	@ApiModelProperty(value="被课调的老师")
    private User user;

	@ApiModelProperty(value="课调的问卷")
    private Questionnaire questionnaire;

	@ApiModelProperty(value="课调的班级的年级")
	private Grade grade;

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Survey [survey=" + survey + ", course=" + course + ", clazz=" + clazz + ", user=" + user
				+ ", questionnaire=" + questionnaire + ", grade=" + grade + "]";
	}

	public SurveyVM() {
		super();
	}

	public SurveyVM(Survey survey, Course course, Clazz clazz, User user, Questionnaire questionnaire,
			Grade grade) {
		super();
		this.survey = survey;
		this.course = course;
		this.clazz = clazz;
		this.user = user;
		this.questionnaire = questionnaire;
		this.grade = grade;
	}

	
	
}
