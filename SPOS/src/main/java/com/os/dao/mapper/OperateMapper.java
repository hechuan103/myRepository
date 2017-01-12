package com.os.dao.mapper;

import java.util.List;

import com.os.base.vo.Operate;

public interface OperateMapper {
	
	public List<Operate> selectAll();
	
	public Operate selectOperate(String LoginId);
	
	public int insertOperate(Operate operate);

}
