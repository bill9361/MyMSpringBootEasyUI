package com.bill.msbeui.util;

import org.apache.log4j.Logger;

/**
 * Description: 日志工具类<br/>
 * Date:2018年7月26日 上午10:21:31 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
public class LoggerUtil
{
	private static Logger logger = Logger.getLogger(LoggerUtil.class);
	
	private LoggerUtil(){}
	
	/**
	 * 获取Log4j
	 * @return
	 */
	public static Logger getLogger()
	{
		return logger;
	}
	
}
