package com.briup.apps.poll.bean.extend;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.User;

/**
 * 处理 多个班级对应一个年级的情况(多对一)
 * @author lixixiaofeng
 *
 */
public class ClazzVM {
	/**
	 * 非外键属性直接映射
	 */
	private Clazz clazz;
	/**
	 * 关联属性处理如下
	 * 通过各自的id找到各自所有的信息
	 */
	private Grade grade;
	private User charge;
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public User getCharge() {
		return charge;
	}
	public void setCharge(User charge) {
		this.charge = charge;
	}
	

}
