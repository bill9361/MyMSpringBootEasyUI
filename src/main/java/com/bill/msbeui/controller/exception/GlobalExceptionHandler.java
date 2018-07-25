package com.bill.msbeui.controller.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


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
	private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler(Exception ex)
	{
		logger.info("GlobalExceptionHandler...哈哈，恭喜您出错啦");
		logger.debug("GlobalExceptionHandler...哈哈，恭喜您出错啦aaaaaaa");
		logger.error(ex.getMessage(), ex);
		return "error/error.jsp";
	}
	
	

}
