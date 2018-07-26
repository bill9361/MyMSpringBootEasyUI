package com.bill.msbeui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill.msbeui.mapper.LoginMapper;
import com.bill.msbeui.service.LoginService;

/**
 * Description: <br/>
 * Date:2018年7月26日 下午2:50:23 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@Service
public class LoginServiceImpl implements LoginService
{
	@Autowired
	private LoginMapper loginMapper;

	/**
	 * 登录
	 */
	@Override
	public String doLogin(String username, String password)
	{
		return loginMapper.doLogin(username, password);
	}
}
