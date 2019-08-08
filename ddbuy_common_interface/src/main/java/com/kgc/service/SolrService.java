package com.kgc.service;

import java.util.Map;

public interface SolrService {
    //导入索引库的方法,将数据库的技术导入到索引库
    public boolean importIndex();

    /**
     *
     * @param condition  传入查询条件
     * @param page  传入页码
     * @return 键值对集合
     *      *       包含当前页的数据 键rows=当前页的数据
     *      *       包含总页数 键totalPage=当页数
     */
    public Map<String,Object> searchProduct(String condition,Integer page);
}
