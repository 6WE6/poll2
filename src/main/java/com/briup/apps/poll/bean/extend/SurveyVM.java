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

	@ApiModelProperty(value="课调的状态")
    private String status;

	@ApiModelProperty(value="课调编码，kd201862701")
    private String code;

	@ApiModelProperty(value="课调的日期，类型为sting")
    private String surveydate;

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

	@Override
	public String toString() {
		return "SurveyVM [id=" + id + ", status=" + status + ", code=" + code + ", surveydate=" + surveydate
				+ ", course=" + course + ", clazz=" + clazz + ", user=" + user + ", questionnaire=" + questionnaire
				+ ", grade=" + grade + ", answers=" + answers + ", fraction=" + fraction + "]";
	}

	public SurveyVM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SurveyVM(Long id, String status, String code, String surveydate, Course course, Clazz clazz, User user,
			Questionnaire questionnaire, Grade grade, List<Answers> answers, int fraction) {
		super();
		this.id = id;
		this.status = status;
		this.code = code;
		this.surveydate = surveydate;
		this.course = course;
		this.clazz = clazz;
		this.user = user;
		this.questionnaire = questionnaire;
		this.grade = grade;
		this.answers = answers;
		this.fraction = fraction;
	}

	

	

}
