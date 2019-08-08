package com.kgc.mapper;

import com.kgc.entity.TbItem;
import com.kgc.entity.TbItemExample;
import com.kgc.util.SolrProduct;

import java.util.List;

public interface TbItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemExample example);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    //查询所需要被导入到索引库的商品信息
    List<SolrProduct> getAllSolrProduct();
}