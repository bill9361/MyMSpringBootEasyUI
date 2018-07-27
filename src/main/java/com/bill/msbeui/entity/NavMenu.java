package com.bill.msbeui.entity;

/**
 * Description: 导航菜单<br/>
 * Date:2018年7月27日 上午10:53:34 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */
@SuppressWarnings("serial")
public class NavMenu extends BaseEntity
{
	 private String name; 		//名称
	 private String state; 		//状态closed,open
	 private String iconCls; 	//
	 private String parentId; 	//父Id
	 private String href;		//链接
	 
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getIconCls()
	{
		return iconCls;
	}
	public void setIconCls(String iconCls)
	{
		this.iconCls = iconCls;
	}
	public String getParentId()
	{
		return parentId;
	}
	public void setParentId(String parentId)
	{
		this.parentId = parentId;
	}
	public String getHref()
	{
		return href;
	}
	public void setHref(String href)
	{
		this.href = href;
	}
	@Override
	public String toString()
	{
		return "NavMenu [name=" + name + ", state=" + state + ", iconCls=" + iconCls + ", parentId=" + parentId
				+ ", href=" + href + ", getId()=" + getId() + ", getCreateTime()=" + getCreateTime()
				+ ", getCreateBy()=" + getCreateBy() + ", getUpdateTime()=" + getUpdateTime() + ", getUpdateBy()="
				+ getUpdateBy() + "]";
	}
	 
}
