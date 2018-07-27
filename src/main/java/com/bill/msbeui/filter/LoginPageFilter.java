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
 * Description: 默认首页过滤器<br/>
 * Date:2018年7月26日 上午10:20:47 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@WebFilter(filterName="LoginPageFilter",urlPatterns={"/","/login.jsp"})
public class LoginPageFilter implements Filter
{

	@Override
	public void destroy(){}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		HttpSession httpSession = ((HttpServletRequest)request).getSession();
		if(httpSession != null)
		{
			String userId = (String) httpSession.getAttribute("userId");
			//如果已经登录，并在有效范围内
			if(StringUtil.isNotEmpty(userId))
			{
				//直接重定向到后台
				((HttpServletResponse)response).sendRedirect(request.getServletContext().getContextPath()+"/pages/admin/main.jsp");
				return;
			}
		}
		String uri = ((HttpServletRequest)request).getRequestURI();
		if("/".equals(uri))
		{
			//重定向到登录页面
			((HttpServletResponse)response).sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");
		}
		else
		{
			//如果是login.jsp直接放行
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException{}

}
