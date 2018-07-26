package com.bill.msbeui.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Description: 登录Mapper<br/>
 * Date:2018年7月26日 下午2:44:46 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */

public interface LoginMapper
{
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return 用户id
	 */
	@Select("select id from user where username=#{username} and password=#{password}")
	public String doLogin(@Param("username") String username,@Param("password") String password);

}
