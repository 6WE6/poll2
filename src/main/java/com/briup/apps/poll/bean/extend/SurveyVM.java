package com.briup.apps.poll.bean.extend;

import java.util.List;

import com.briup.apps.poll.bean.Answers;
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

	@ApiModelProperty(value="主键自增策略")
    private Long id;

	@ApiModelProperty(value="课调的状态，1为未开始，2为进行中，3为结束")
    private String status;

	@ApiModelProperty(value="课调编码，kd201862701")
    private String code;

	@ApiModelProperty(value="课调的日期，类型为sting")
    private String surveydate;

	@ApiModelProperty(value="课调的课程")
	private Course course;

	@ApiModelProperty(value="课调的班级")
	private ClazzVM clazzVM;

	@ApiModelProperty(value="被课调的老师")
	private User user;

	@ApiModelProperty(value="课调的问卷")
	private Questionnaire questionnaire;

	@ApiModelProperty(value="课调的班级的年级")
	private Grade grade;

	//peng
	@ApiModelProperty(value="课调的答题卡")
	private List<Answers> answers;

	//	分数 peng
	@ApiModelProperty(value="课调的平均分")
	private int fraction;

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
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSurveydate() {
		return surveydate;
	}

	public void setSurveydate(String surveydate) {
		this.surveydate = surveydate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public ClazzVM getClazzVM() {
		return clazzVM;
	}

	public void setClazzVM(ClazzVM clazzVM) {
		this.clazzVM = clazzVM;
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

	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}

	public int getFraction() {
		return fraction;
	}

	public void setFraction(int fraction) {
		this.fraction = fraction;
	}

	

	
	

	

}
