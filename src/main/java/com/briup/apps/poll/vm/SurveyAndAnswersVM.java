package com.briup.apps.poll.vm;

import java.util.List;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.bean.extend.SurveyVM;
/**
 * 课调和答案的VM
 * @author yun
 *
 */
public class SurveyAndAnswersVM {
	private SurveyVM surveyVM;
	private List<Answers> answers;
	
	public SurveyVM getSurveyVM() {
		return surveyVM;
	}
	public void setSurveyVM(SurveyVM surveyVM) {
		this.surveyVM = surveyVM;
	}
	public List<Answers> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}
	
}
