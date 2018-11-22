package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

/*
 * 品牌接口
 */
public interface BrandServiceI {
	//查询所有品牌信息
	public List<TbBrand> findAll();
	//分页查询品牌
	public PageResult findPage(int pageNum, int pageSize);
	//添加品牌
	public void add(TbBrand brand);
	//回显品牌
	public TbBrand findOne(Long id);
	//修改品牌
	public void update(TbBrand brand);
	//删除品牌
	public void delete(Long[] ids);
	//模糊搜索并分页
	public PageResult findPage(TbBrand brand,int pageNum, int pageSize);
}
