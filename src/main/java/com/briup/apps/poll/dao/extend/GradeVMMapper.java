package com.briup.apps.poll.dao.extend;

import com.briup.apps.poll.bean.extend.GradeVM;

/**
 * vm类到层处理
 * @author psq
 *
 */
public interface GradeVMMapper 
{
	//根据年级id查询学校和年级的信息
	GradeVM findSchoolbyGrade(Long id);
	
	//根据年级id查询班级和年级的信息
	GradeVM findClazzbyGrade(Long id);

}
