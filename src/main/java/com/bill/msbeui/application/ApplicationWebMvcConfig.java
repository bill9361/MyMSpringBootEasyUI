package com.bill.msbeui.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bill.msbeui.interceptor.GlobalInterceptor;
import com.bill.msbeui.util.LoggerUtil;

/**
 * 需要包扫描能扫描得到@Configuration
 * Description: SpringMVC的拦截器配置<br/>
 * Date:2018年7月25日 上午11:42:04 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@Configuration
//SpringBoot通过WebMvcAutoConfiguration来完成与Mvc有关的自动配置。如果希望完全接管WebMvc自动配置，可以在项目中创建一个注解了@EnableWebMvc的配置类
//@EnableWebMvc
public class ApplicationWebMvcConfig implements WebMvcConfigurer 
{

	/**
	 * SpringBoot启动时就自动自行该方法
	 * 配置拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		LoggerUtil.getLogger().info("ApplicationWebMvcConfig......addInterceptors()");
		registry.addInterceptor(new GlobalInterceptor())
		//拦截所有
		.addPathPatterns("/**");
		//不拦截以下URL
		//.excludePathPatterns("/company/getCompanysByName1.do");
	}
	
	/**
	 * 需在类上加上@EnableWebMvc注解
	 * 资源访问处理器
	 * 其中默认配置的 /** 映射到 /static （或/public、/resources、/META-INF/resources）
	 * 优先级顺序为：META-INF/resources > resources > static > public
	 * 如果以上默认不够用，则按这个方法增加资源映射
	 * 
	 * 可以在jsp中使用/aa/**的方式访问/static/下的内容>  
	 */
	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		LoggerUtil.getLogger().info("ApplicationWebMvcConfig...addResourceHandlers()");
		registry.addResourceHandler("/aa/**").addResourceLocations("classpath:/static/");
	}*/
	
}
