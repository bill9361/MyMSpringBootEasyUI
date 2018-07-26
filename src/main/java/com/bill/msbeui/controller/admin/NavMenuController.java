package com.bill.msbeui.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: <br/>
 * Date:2018年7月26日 下午5:23:07 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@RequestMapping("/navMenu")
@Controller
public class NavMenuController
{

	/**
	 * 获取导航菜单
	 * @return
	 */
	@RequestMapping("/getNavMenu.do")
	@ResponseBody
	public boolean getNavMenu(String parentId)
	{
		return false;
	}
}
