package com.kgc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.TbContentCategory;
import com.kgc.mapper.TbContentCategoryMapper;
import com.kgc.service.TbContentCategoryService;
import com.kgc.util.DataGridResult;
import com.kgc.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass =TbContentCategoryService.class )
@Component
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired(required = false)
    private TbContentCategoryMapper tbContentCategoryMapper;
    @Override
    public DataGridResult<TbContentCategory> getAllTbContentCategory(Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        List<TbContentCategory> tbContentCategories = tbContentCategoryMapper.selectByExample(null);
        PageInfo<TbContentCategory> tbContentCategoryPageInfo = new PageInfo<>(tbContentCategories);
        return new DataGridResult<TbContentCategory>(tbContentCategoryPageInfo.getTotal(),tbContentCategoryPageInfo.getList());
    }

    @Override
    @Transactional
    public int addTbContentCategory(TbContentCategory tbContentCategory) {
        int flag = tbContentCategoryMapper.insertSelective(tbContentCategory);
        return flag;
    }

    @Override
    public int deleteTbContentCategoryById(Integer id) {

        int flag = tbContentCategoryMapper.deleteByPrimaryKey(id.longValue());
        return flag;
    }

    @Override
    public TbContentCategory getSingleTbContentCategory(Integer id) {
        TbContentCategory tbContentCategory = tbContentCategoryMapper.selectByPrimaryKey(id.longValue());
        return tbContentCategory;
    }

    @Override
    public int updateTbContentCategory(TbContentCategory tbContentCategory) {
        int temp = tbContentCategoryMapper.updateByPrimaryKeySelective(tbContentCategory);
        return temp;
    }

    @Override
    public List<TbContentCategory> getAllTbContentCategory() {
        return tbContentCategoryMapper.selectByExample(null);
    }
}
