package com.kgc.service;

import com.kgc.entity.TbItem;

public interface TbItemService {
    /**
     * 生成所有商品的静态页面
     * @return
     */
    public boolean processHtml();

    public boolean processHtml(TbItem tbItem);
}
