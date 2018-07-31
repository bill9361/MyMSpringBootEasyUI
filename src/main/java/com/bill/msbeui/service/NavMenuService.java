package com.bill.msbeui.service;

import java.util.List;
import java.util.Map;

/**
 * Description: <br/>
 * Date:2018年7月27日 上午11:07:10 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */

public interface NavMenuService
{

	List<Map<String, Object>> getNavMenuByParentId(String parentId);

	Map<String,Object> getNavMenu(int pageNumber,int rows);

	boolean addNavMenu(Map<String, Object> paramMap);

	boolean deleteNavMenu(String ids);

}