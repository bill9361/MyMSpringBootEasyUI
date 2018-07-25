package com.bill.msbeui.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description:全局拦截器 <br/>
 * Date:2018年7月25日 下午1:47:24 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
public class GlobalInterceptor implements HandlerInterceptor
{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exception)
			throws Exception
	{
		System.out.println("GlobalInterceptor....afterCompletion()");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView exception)
			throws Exception
	{
		System.out.println("GlobalInterceptor....postHandle()");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception
	{
		System.out.println("GlobalInterceptor....preHandle()");
		//默认全部放行
		return true;
	}

}
