package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.ClazzVM;

/**
 * 数据访问中间层 班级
 * 
 * @author lixiaofeng
 *
 */
public interface ClazzVMMapper {
	/**
	 * 查询所有年级信息
	 * 
	 * @return
	 */
	List<ClazzVM> selectAll();

	ClazzVM selectClazzVMById(long id);

	List<ClazzVM> selectClazzByKeyword(String keywords);

}
