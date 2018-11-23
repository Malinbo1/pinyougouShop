package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandServiceI;

/**
 *品牌服务实现类
 */
@Service
public class BrandServiceImpl implements BrandServiceI{
	@Autowired
	private TbBrandMapper tbBrandMapper;

	@Override
	public List<TbBrand> findAll() {
		//调用dao层查询数据库得到数据
		return tbBrandMapper.selectByExample(null);
	}
	
	
	

}
