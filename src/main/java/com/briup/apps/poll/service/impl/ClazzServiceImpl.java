
package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.ClazzExample;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.dao.ClazzMapper;
import com.briup.apps.poll.dao.extend.ClazzVMMapper;
import com.briup.apps.poll.service.IClazzService;

/**
 * 业务逻辑接口实现 班级
 * 
 * @author lixiaofeng
 *
 */
@Service
public class ClazzServiceImpl implements IClazzService {
	@Autowired
	private ClazzMapper clazzMapper;
	@Autowired
	private ClazzVMMapper clazzVMMapper;

	/**
	 * 查询所有班级信息
	 */

	@Override
	public List<Clazz> findAllClazz() throws Exception {
		ClazzExample example = new ClazzExample();
		return clazzMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<ClazzVM> findAllClazzVM() throws Exception {
		return clazzVMMapper.selectAll();
	}

	/**
	 * 根据id查询所有班级信息
	 */

	@Override
	public Clazz findClazzById(long id) throws Exception {
		return clazzMapper.selectByPrimaryKey(id);
	}

	@Override
	public ClazzVM findClazzVMById(long id) throws Exception {
		return clazzVMMapper.selectClazzVMById(id);
	}

	/**
	 * 根据关键字查询所有班级信息
	 */
	@Override
	public List<Clazz> query(String keywords) throws Exception {
		ClazzExample example = new ClazzExample();
		example.createCriteria().andNameLike(keywords);
		return clazzMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<ClazzVM> findClazzVMByKeyword(String keywords) throws Exception {
		return clazzVMMapper.selectClazzByKeyword(keywords);
	}

	/**
	 * 保存或者更新班级信息
	 */

	@Override
	public void saveOrUpdateClazz(Clazz clazz) throws Exception {
		if (clazz.getId() != null) {
			// 更新
			clazzMapper.updateByPrimaryKey(clazz);
		} else {
			// 插入
			clazzMapper.insert(clazz);
		}
	}

	/**
	 * 根据id删除班级信息
	 */

	@Override
	public void deleteClazzById(long id) throws Exception {
		clazzMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 批量删除班级信息
	 */

	@Override
	public void batchDeleteClazz(long[] ids) throws Exception {
		for (long id : ids) {
			clazzMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public List<Clazz> findClazzByKeyword(String keywords) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
