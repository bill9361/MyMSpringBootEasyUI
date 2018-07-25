package com.bill.msbeui.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bill.msbeui.interceptor.GlobalInterceptor;

/**
 * 需要包扫描能扫描得到@Configuration
 * Description: SpringMVC的拦截器配置<br/>
 * Date:2018年7月25日 上午11:42:04 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@Configuration
public class ApplicationWebMvcConfig extends WebMvcConfigurerAdapter
{

	/**
	 * SpringBoot启动时就自动自行该方法
	 * 配置拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		System.out.println("ApplicationWebMvcConfig......addInterceptors()");
		registry.addInterceptor(new GlobalInterceptor())
		//拦截所有
		.addPathPatterns("/**");
		//不拦截以下URL
		//.excludePathPatterns("/company/getCompanysByName1.do");
		super.addInterceptors(registry);
	}
	
}
