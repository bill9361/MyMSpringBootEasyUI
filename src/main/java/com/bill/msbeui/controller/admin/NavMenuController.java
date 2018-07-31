package com.bill.msbeui.controller.admin;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bill.msbeui.service.NavMenuService;
import com.bill.msbeui.util.TimeUtil;

/**
 * Description: <br/>
 * Date:2018年7月26日 下午5:23:07 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@RequestMapping("/navMenu")
@Controller
public class NavMenuController
{
	@Autowired
	private NavMenuService navMenuService;

	/**
	 * .tree()默认封装了ajax,并且点击的任意节点的时候，会发送节点的id,所以，此方法接收id字段即可。
	 * 文档中提到：它将会把节点id的值作为http请求参数并命名为'id'，通过URL发送到服务器上面检索子节点。
	 * 根据父Id获取导航菜单
	 * @return 通过@ResponseBody将List<Map<String,Object>>返回Json给.tree()
	 */
	@RequestMapping("/getNavMenuByParentId.do")
	@ResponseBody
	public List<Map<String,Object>> getNavMenuByParentId(@RequestParam(value="id",defaultValue="0") String parentId)
	{
		return navMenuService.getNavMenuByParentId(parentId);
	}
	
	/**
	 * 获取导航菜单,其中page和rows参数是EasyUI分页空间返回来的数据
	 * @param page 页码
	 * @param rows 每页行数
	 * @return 返回Json格式数据
	 */
	@RequestMapping("/getNavMenu.do")
	@ResponseBody
	public Map<String,Object> getNavMenu(int page,int rows) throws Exception
	{
		return navMenuService.getNavMenu(page,rows);
	}
	
	/**
	 * 添加菜单
	 * @param navMenuMap
	 * @return 成功或失败
	 */
	@RequestMapping("/addNavMenu.do")
	@ResponseBody
	public boolean addNavMenu(HttpSession httpSession,@RequestBody Map<String, Object> paramMap) throws Exception
	{
		//添加Id
		paramMap.put("id", UUID.randomUUID().toString().trim());
		paramMap.put("state", "open");
		paramMap.put("createBy", httpSession.getAttribute("userId"));
		paramMap.put("createTime", TimeUtil.getCurrentTime());
		return navMenuService.addNavMenu(paramMap);
	}
	/**
	 * 获取父级导航菜单
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getFirstNavMenu.do")
	@ResponseBody
	public List<Map<String,Object>> getFirstNavMenu() throws Exception
	{
		return navMenuService.getNavMenuByParentId("0");
	}
	

	/**
	 * 删除导航菜单
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteNavMenu.do")
	@ResponseBody
	public boolean deleteNavMenu(String ids) throws Exception
	{
		return navMenuService.deleteNavMenu(ids);
	}
}
