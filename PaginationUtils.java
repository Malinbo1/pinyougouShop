package com.qixin.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PaginationUtils {
	public static void getPage(HttpServletRequest request,List<?> list,String url,Integer cpage,Integer count,Integer pageSize) {
		//计算总页数
		int tpage = ( count / pageSize ) + ( cpage % pageSize == 0  ?  0 : 1);
		//设置 首页  上一页  下一页  末页
        String first = "";
        String prev = "";
        String next = "";
        String last ="";
        //设置拼接&
        String flag = url.indexOf("?") > -1 ? "&": "?" ;
        //判断当前页
        if(cpage==1) {//首页和上一页无效
        	first = "首页";
        	prev= "上一页";
        }else {//如果当前页不为1，则可以用超链接跳转
            first = "<a href=' "+request.getContextPath() + "/" + url + flag +"cpage=1" +" '>首页</a>";   
            prev = "<a href=' "+request.getContextPath() + "/" + url + flag + "cpage="+ ( cpage - 1 ) +" ' >上一页</a>";
        }
        
        if(cpage==tpage) {
        	next = "下一页";
        	last = "末页";
        }else {
        	next = "<a href =' "+request.getContextPath() + "/" + url + flag + "cpage=" + ( cpage + 1 ) +" '>下一页</a>";
        	last = "<a href=' "+request.getContextPath() + "/" + url + flag + "cpage=" + tpage +" '>末页</a>";
        }
		
		//然后利用request,将这些东西传入前台
        request.setAttribute("list", list);
		request.setAttribute("cpage", cpage);
		request.setAttribute("tpage", tpage);
		request.setAttribute("count", count);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("page", first + " "+ prev + " "+ next + " "+last);
	}

}
