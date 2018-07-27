package com.bill.msbeui.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Description: 导航菜单Mapper <br/>
 * Date:2018年7月26日 下午5:26:17 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */

public interface NavMenuMapper
{
	/**
	 * 根据父Id获取导航菜单
	 * @param parentId
	 * @return
	 */
	@Select("select id,name as text,state,iconCls,parentId,href,createTime,createBy,updateTime,updateBy from nav_menu where parentId=#{parentId} order by name")
	public List<Map<String,Object>> getNavMenuByParentId(@Param("parentId") String parentId);
	
	/**
	 * 获取导航菜单
	 * @param startIndex 从第几条开始
	 * @param rows 读取多少条
	 * @return
	 */
	@Select("select id,name as text,state,iconCls,parentId,href,createTime,createBy,updateTime,updateBy from nav_menu limit ${startIndex},${rows}")
	public List<Map<String,Object>> getNavMenu(@Param("startIndex") int startIndex,@Param("rows") int rows);
	
	/**
	 * 获取导航菜单总条数
	 * @return
	 */
	@Select("select count(*) from nav_menu")
	public int getCount();
	

	/**
	 * 添加导航菜单
	 * @return
	 */
	@Insert("INSERT INTO nav_menu ('id', 'name', 'state', 'iconCls', 'parentId', 'href', 'createTime', 'createBy') VALUES (#{id}, #{name}, #{state}, #{iconCls}, #{parentId}, #{href}, #{createTime}, #{createBy})")
	public int addNavMenu(Map<String,Object> paramMap);

}
