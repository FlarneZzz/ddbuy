package com.kgc.service;

import com.kgc.entity.TbContentCategory;
import com.kgc.util.DataGridResult;
import com.kgc.util.Page;

import java.util.List;


public interface TbContentCategoryService {
    //查询所有广告类型
    DataGridResult<TbContentCategory> getAllTbContentCategory(Page page);

    int addTbContentCategory(TbContentCategory tbContentCategory);

    int deleteTbContentCategoryById(Integer id);

    TbContentCategory getSingleTbContentCategory(Integer id);

    int updateTbContentCategory(TbContentCategory tbContentCategory);
    //查询所有广告
    List<TbContentCategory> getAllTbContentCategory();
}
