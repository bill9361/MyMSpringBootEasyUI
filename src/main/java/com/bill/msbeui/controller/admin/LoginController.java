package com.bill.msbeui.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bill.msbeui.service.LoginService;
import com.bill.msbeui.util.StringUtil;

/**
 * Description: <br/>
 * Date:2018年7月25日 下午2:49:51 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@Controller
@RequestMapping("/login")
public class LoginController
{
	@Autowired
	private LoginService loginService;

	/**
	 * 是否成功登录
	 * @return
	 */
	@RequestMapping("/doLogin.do")
	@ResponseBody
	public boolean doLogin(HttpServletRequest request,HttpServletResponse response,HttpSession httpSession,String username,String password)
	{
		System.out.println("LoginController...isLogin()");
		System.out.println("username:"+username+" password:"+password);
		String userId = loginService.doLogin(username, password);
		if(StringUtil.isNotEmpty(userId))
		{
			//把登录成功的UserId放入到Session中
			httpSession.setAttribute("userId", userId);
			return true;
		}
		return false;
	}
	
}
