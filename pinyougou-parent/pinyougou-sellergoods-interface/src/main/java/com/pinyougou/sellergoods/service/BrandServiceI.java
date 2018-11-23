package com.pinyougou.sellergoods.service;
/**
 *品牌接口
 */

import java.util.List;

import com.pinyougou.pojo.TbBrand;

public interface BrandServiceI {
	//查询所有品牌
	public List<TbBrand> findAll();

}
