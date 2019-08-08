package com.kgc.service;

import com.kgc.entity.TbContent;

import java.util.List;

public interface TbContentService {
    public int addContent(TbContent tbContent);
    //获取所有广告
    public List<TbContent> getAllTbContent();
}
