package com.briup.apps.poll.bean.extend;

import java.io.Serializable;
import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.School;

/**
 * GradeVM类  扩展类
 * @author psq
 *
 */
public class GradeVM implements Serializable  {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	//年级对应的学校
	private Grade grade;
	
	//年级对应的学校
	private School school;
	
	

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GradeVM [school=" + school + ", grade=" + grade + "]";
	}

	public GradeVM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GradeVM(School school, Grade grade) {
		super();
		this.school = school;
		this.grade = grade;
	}

	

}
