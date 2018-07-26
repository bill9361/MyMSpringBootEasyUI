package com.bill.msbeui.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Description: SpringBoot启动类<br/>
 * Date:2018年7月24日 下午1:23:22 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
//@SpringBootApplication 等同于默认的属性的 @Configuration, @EnableAutoConfiguration and @ComponentScan。
@SpringBootApplication(scanBasePackages={"com.bill.msbeui.controller.*","com.bill.msbeui.service.impl","com.bill.msbeui.application"})
//@ServletComponentScan结合Filter类的@WebFilter注解，完成过滤器的配置
@ServletComponentScan(basePackages={"com.bill.msbeui.filter"})
@MapperScan(value={"com.bill.msbeui.mapper"})
public class ApplicationMain
{
	public static void main(String[] args)
	{
		//启动SpringBoot
		SpringApplication.run(ApplicationMain.class, args);
	}
	
	/**
	 * 修改DispatcherServlet默认配置
	 * dispatcherServlet会接管所有请求（包括静态资源请求），如果修改默认的UrlMapping为*.do，那么一定会导致静态资源无法加载。
	 * 就算在WebMvcConfigurerAdapter中配置了addResourceHandlers也没用。
	 * 以前在SpringMVC中的DispatcherServlet配置*.do的目的是只拦截*.do的请求，目的是映射到Controller中，现在只需要在Controller中的方式上@RequestMapping("**.do")即可。
	 * 或者再拦截器中拦截(个人觉得不需要,无需加.do一样能映射，但是不加后缀，表示：加任何后缀都能访问)
	 * @param dispatcherServlet
	 * @return
	 */
	/*@Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) 
	{
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.getUrlMappings().clear();
        registration.addUrlMappings("*.do");
        return registration;
    }*/
	
}
