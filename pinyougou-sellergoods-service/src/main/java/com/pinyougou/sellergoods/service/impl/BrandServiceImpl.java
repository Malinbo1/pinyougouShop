package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandServiceI;

@Service
public class BrandServiceImpl implements BrandServiceI{
	
	@Autowired
	private TbBrandMapper brandMapper;
	
	//查询所有品牌
	@Override
	public List<TbBrand> findAll() {
		return brandMapper.selectByExample(null);
	}
	
	//分页查询品牌信息
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
	//添加品牌
	@Override
	public void add(TbBrand brand) {
		brandMapper.insert(brand);
	}
	
	//回显品牌
	@Override
	public TbBrand findOne(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}
	
	//修改品牌
	@Override
	public void update(TbBrand brand) {
		brandMapper.updateByPrimaryKey(brand);
	}
	
	//删除品牌
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			brandMapper.deleteByPrimaryKey(id);
		}
	}
	
	//模糊搜索并分页
	@Override
	public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbBrandExample example = new TbBrandExample();
		Criteria criteria = example.createCriteria();
		if(brand != null) {
			if(brand.getName() != null && brand.getName().length()>0) {
				criteria.andNameLike("%" + brand.getName() + "%");
			}
			if(brand.getFirstChar() != null && !"".equals(brand.getFirstChar())) {
				criteria.andFirstCharLike("%" + brand.getFirstChar() + "%");
			}
		}
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
	
}
