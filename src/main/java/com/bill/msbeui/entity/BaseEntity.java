package com.bill.msbeui.entity;

import java.io.Serializable;

/**
 * 作者Email:fengminbiao@126.com
 * 创建时间：2018年7月2日下午2:46:00
 * 类说明：POJO基类
 */
@SuppressWarnings("serial")
public class BaseEntity implements Serializable
{
	private String id;
	private String createTime;
	private String createBy;
	private String updateTime;
	private String updateBy;
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}
	public String getCreateBy()
	{
		return createBy;
	}
	public void setCreateBy(String createBy)
	{
		this.createBy = createBy;
	}
	public String getUpdateTime()
	{
		return updateTime;
	}
	public void setUpdateTime(String updateTime)
	{
		this.updateTime = updateTime;
	}
	public String getUpdateBy()
	{
		return updateBy;
	}
	public void setUpdateBy(String updateBy)
	{
		this.updateBy = updateBy;
	}
	@Override
	public String toString()
	{
		return "id=" + id + ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime="
				+ updateTime + ", updateBy=" + updateBy + "";
	}
	
	

}
