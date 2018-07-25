package com.bill.msbeui.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: <br/>
 * Date:2018年7月25日 下午2:49:51 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@Controller
public class LoginController
{

	/**
	 * 配置默认页面
	 * @return
	 */
	@RequestMapping("/")
	public String toLoginPage()
	{
		return "redirect:/login.jsp";
	}
	
	
}
