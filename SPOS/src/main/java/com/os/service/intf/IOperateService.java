package com.os.service.intf;

import java.util.List;

import com.os.base.vo.Operate;

public interface IOperateService {
	
	public List<Operate> selectAll();
	
	public Operate selectByLoginId(String LoginId);
	
	public int insert(Operate operate);

}
