package com.bill.msbeui.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bill.msbeui.util.StringUtil;

/**
 * Description: 后台登录验证过滤器(过滤静态资源文件和jsp等页面)<br/>
 * Date:2018年7月26日 下午3:57:20 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@WebFilter(filterName="AdminLoginValidateFilter",urlPatterns={"/pages/admin/*"})
public class AdminLoginValidateFilter implements Filter
{

	@Override
	public void destroy(){}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		System.out.println("AdminLoginValidateFilter....doFilter()");
		HttpSession httpSession = ((HttpServletRequest)request).getSession();
		if(httpSession != null)
		{
			String userId = (String) httpSession.getAttribute("userId");
			System.out.println(userId);
			if(StringUtil.isNotEmpty(userId))
			{
				//放行
				chain.doFilter(request, response);
				return;
			}
		}
		
		//重定向到登录页面
		((HttpServletResponse)response).sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException{}

}
