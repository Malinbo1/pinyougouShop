package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandServiceI;

@RestController
@RequestMapping(value="/brand")
public class BrandController {
	
	@Reference
	private BrandServiceI brandSer;
	
	@RequestMapping(value="/sss")
	public void sss() {
		System.out.println("访问项目成功");
	}
	
	@RequestMapping(value="/findAll")
	public List<TbBrand> findAll(){
		
		return brandSer.findAll();
	}

}
