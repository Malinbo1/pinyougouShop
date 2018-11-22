package com.pinyougou.manager.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandServiceI;


@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Reference
	private BrandServiceI brandServiceI;
	
	//查询所有品牌
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandServiceI.findAll();
	}
	
	//分页查询
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int rows) {
		return brandServiceI.findPage(page, rows);
	}
	
	//新增数据
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand brand) {
		try {
			brandServiceI.add(brand);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(true, "添加失败");
		}
	}
	
	//回显数据
	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
		return brandServiceI.findOne(id);
	}
	
	//修改数据
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand brand) {
		try {
			brandServiceI.update(brand);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(true, "修改失败");
		}
	}
	
	//删除品牌
	@RequestMapping("/delete")
	public Result delete(Long[] ids) {
		try {
			brandServiceI.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	//模糊搜索并分页
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand brand,int page, int rows) {
		return brandServiceI.findPage(brand, page, rows);
	}
}
