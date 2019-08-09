package com.kgc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kgc.entity.TbContent;
import com.kgc.entity.TbContentExample;
import com.kgc.mapper.TbContentMapper;
import com.kgc.service.TbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service(interfaceClass = TbContentService.class)
@Component
public class TbContentServiceImpl implements TbContentService {
    @Autowired(required = false)
    private TbContentMapper tbContentMapper;
    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public int addContent(TbContent tbContent) {
        int temp=-1;
        try {
            temp=tbContentMapper.insertSelective(tbContent);
            this.getTbContents(redisTemplate.opsForValue());
        } catch (Exception e) {
           e.printStackTrace();
        }
        return temp;
    }

    //redis缓存 缓存中有就从缓存中拿,没有就从数据库中查,然后设置到缓存中

    @Override
    public List<TbContent> getAllTbContent() {
        List<TbContent> tbcontent=null;
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        if (this.redisTemplate.hasKey("Tbcontent")){
            System.out.println("从缓存中获取");
            tbcontent = (List<TbContent>) valueOperations.get("Tbcontent");
        }else{
            System.out.println("从数据库中获取");
            tbcontent=getTbContents(valueOperations);
        }
        return tbcontent;
    }
//封装的方法
// 设置redis中的缓存  ctrl+alt+M
    private List<TbContent> getTbContents(ValueOperations valueOperations) {
        TbContentExample tbContentExample = new TbContentExample();
        TbContentExample.Criteria criteria = tbContentExample.createCriteria();
        criteria.andStatusEqualTo("1");
        List<TbContent> tbContents = tbContentMapper.selectByExample(tbContentExample);
        valueOperations.set("Tbcontent",tbContents,1,TimeUnit.DAYS);
        return tbContents;
    }
}
