package com.bill.msbeui.controller.front;

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
public class HomeController
{

	@RequestMapping("/")
	public String toIndex()
	{
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/testException.do")
	public void testException()
	{
		int i = 10/0;
	}
}
