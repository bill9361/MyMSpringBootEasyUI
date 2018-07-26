package com.bill.msbeui.service;

/**
 * Description: <br/>
 * Date:2018年7月26日 下午2:59:02 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */

public interface LoginService
{

	/**
	 * 是否成功登录
	 * @param username
	 * @param password
	 * @return 用户Id
	 */
	String doLogin(String username, String password);

}