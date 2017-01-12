package com.os.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.base.vo.UserInfo;
import com.os.base.vo.UserInfoExample;
import com.os.dao.mapper.UserInfoMapper;
import com.os.service.intf.IUserInfoService;

/**
 * 
 * @title  用户基础数据
 * @author HC
 * @date 2016-12-26下午4:37:06
 * @class UserInfoServiceImpl
 * @package com.os.service.impl
 * @project SPOS
 * @describe 
 *
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	public int insertSelective(UserInfo record) {
		return userInfoMapper.insertSelective(record);
	}

	public List<UserInfo> selectByExample(UserInfoExample example) {
		return userInfoMapper.selectByExample(example);
	}

	public UserInfo selectByPrimaryKey(Integer id) {
		
		return userInfoMapper.selectByPrimaryKey(id);
	}

}
