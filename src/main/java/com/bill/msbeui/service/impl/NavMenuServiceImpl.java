package com.bill.msbeui.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bill.msbeui.mapper.NavMenuMapper;
import com.bill.msbeui.service.NavMenuService;
import com.bill.msbeui.util.StringUtil;

/**
 * Description: 导航菜单Service<br/>
 * Date:2018年7月27日 上午11:05:40 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@Service
public class NavMenuServiceImpl implements NavMenuService
{
	@Autowired
	private NavMenuMapper navMenuMapper;
	
	/**
	 * 根据父Id获取导航菜单
	 */
	@Override
	public List<Map<String,Object>> getNavMenuByParentId(String parentId)
	{
		//如果为空，则默认查一级菜单,可以在
		//if(parentId == null || "".equals(parentId)) parentId = "0";
		return navMenuMapper.getNavMenuByParentId(parentId);
	}
	
	/**
	 * 获取导航菜单
	 */
	@Override
	public Map<String,Object> getNavMenu(int pageNumber,int rows)
	{
		int startIndex = (pageNumber - 1) * rows;
		//获取导航菜单数据
		List<Map<String,Object>> rowsList = navMenuMapper.getNavMenu(startIndex, rows);
		//获取总条数
		int total = navMenuMapper.getCount();
		
		//返回包含total和rows的key的Json给EasyUI即可分页显示数据
		Map<String,Object> paginationDataMap = new HashMap<>();
		paginationDataMap.put("total", total);
		paginationDataMap.put("rows", rowsList);
		
		return paginationDataMap;
	}
	
	/**
	 * 添加导航菜单
	 * @param paramMap
	 * @return
	 */
	@Transactional(readOnly=false)
	@Override
	public boolean addNavMenu(Map<String,Object> paramMap)
	{
		int flag = navMenuMapper.addNavMenu(paramMap);
		if(flag >= 0)
		{
			//如果不是父级菜单
			if(!paramMap.get("parentId").equals("0"))
			{
				//则要要修改其父级菜单的state为closed
				navMenuMapper.updateNavMenuState("closed", paramMap.get("parentId").toString().trim());
			}
			
			return true;
		}
		return false;
	}

	/**
	 * 删除导航菜单
	 */
	@Override
	public boolean deleteNavMenu(String ids)
	{
		if(StringUtil.isNotEmpty(ids))
		{
			System.out.println("处理前："+ids);
			ids = "'"+ids.substring(0, ids.length()-2);
			System.out.println("deleteNavMenu:"+ids);
			int flag = navMenuMapper.deleteNavMenu(ids);
			return (flag > 0)?true:false;
		}
		return false;
	}

}
