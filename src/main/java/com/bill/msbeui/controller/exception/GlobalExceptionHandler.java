package com.bill.msbeui.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bill.msbeui.util.LoggerUtil;


/**
 * Description: 全局异常处理 <br/>
 * Date:2018年7月25日 下午2:44:57 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@ControllerAdvice
public class GlobalExceptionHandler
{
	
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler(Exception ex)
	{
		LoggerUtil.getLogger().info("GlobalExceptionHandler...哈哈，恭喜您出错啦");
		LoggerUtil.getLogger().error(ex.getMessage(), ex);
		return "error/error.jsp";
	}
	
	

}
