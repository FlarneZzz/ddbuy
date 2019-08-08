package com.kgc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.entity.TbContentCategory;
import com.kgc.service.TbContentCategoryService;
import com.kgc.util.DataGridResult;
import com.kgc.util.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TbContentCategoryController {
    @Reference(interfaceClass = TbContentCategoryService.class)
    private TbContentCategoryService tbContentCategoryService;

    //查看所有广告类型
    @RequestMapping("/getTbContentCategory")
    public DataGridResult<TbContentCategory> getTbContentCategory(Page page) {
        return tbContentCategoryService.getAllTbContentCategory(page);
    }
    //添加广告类型
    @RequestMapping("/addTbContentCategory")
    public String addTbContentCategory(TbContentCategory tbContentCategory){
        int flag = tbContentCategoryService.addTbContentCategory(tbContentCategory);
        return "{\"result\":"+flag+"}";
    }
    //批量删除广告类型
    @RequestMapping("/deleteTbContentCategory")
    public String deleteTbContentCategory(Integer id){
        try {
            tbContentCategoryService.deleteTbContentCategoryById(id);
            return "{\"result\":"+1+"}";
        } catch (Exception e) {
            System.out.println("出错了");
        }
            return "{\"result\":"+0+"}";
    }
    //获得单个广告类型通过主键
    @RequestMapping("/getSingleTbContentCategory")
   public TbContentCategory getSingleTbContentCategory(Integer id){
        TbContentCategory singleTbContentCategory = tbContentCategoryService.getSingleTbContentCategory(id);
        return singleTbContentCategory;
    }
    //修改广告类型
    @RequestMapping("/updateTbContentCategory")
    public String updateTbContentCategory(TbContentCategory tbContentCategory){
        int temp=tbContentCategoryService.updateTbContentCategory(tbContentCategory);
               return "{\"result\":"+temp+"}";
    }
    //查询所有广告类型
    @RequestMapping("/getAllTbContentCategory")
    public List<TbContentCategory> getAllTbContentCategory(){
        List<TbContentCategory> allTbContentCategory = tbContentCategoryService.getAllTbContentCategory();
        return allTbContentCategory;
    }
}
