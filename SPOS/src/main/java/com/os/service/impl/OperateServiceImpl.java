package com.os.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.base.vo.Operate;
import com.os.dao.mapper.OperateMapper;
import com.os.service.intf.IOperateService;

@Service("operateService")
public  class OperateServiceImpl implements IOperateService {
	@Autowired
	private  OperateMapper operateMapper;

	public List<Operate> selectAll() {
		return operateMapper.selectAll();
	}

	public Operate selectByLoginId(String LoginId) {
		return operateMapper.selectOperate(LoginId);
	}

	public int insert(Operate operate) {
		return operateMapper.insertOperate(operate);
	}

}
