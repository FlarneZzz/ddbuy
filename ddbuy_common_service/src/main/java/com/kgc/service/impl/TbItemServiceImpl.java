package com.kgc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kgc.entity.TbItem;
import com.kgc.mapper.TbItemMapper;
import com.kgc.service.TbItemService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = TbItemService.class)
@Component
public class TbItemServiceImpl implements TbItemService {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private Configuration configuration;

    @Override
    public boolean processHtml() {
        try {
            //1.查询所有的商品信息
            List<TbItem> tbItems = tbItemMapper.selectByExample(null);
            //2.将每个商品基于freemarker生成静态页面
            for (TbItem p : tbItems) {
                //加载模板
                Template template = configuration.getTemplate("Product.ftl");
                //创建模型数据
                Map<String, Object> maps = new HashMap<>();
                maps.put("p", p);
                //生成静态页面, 注意:商品的名称即为静态网页名
                FileWriter w = new FileWriter("G:\\FreeMarker-HTML\\" + p.getId() + ".html");
                template.process(maps, w);
                w.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean processHtml(TbItem tbItem) {
        Template template = null;
        try {
            //1.查询所有的商品信息
            List<TbItem> tbItems = tbItemMapper.selectByExample(null);
            //2.将每个商品基于freemarker生成静态页面

            //加载模板
            template = configuration.getTemplate("Product.ftl");
            //创建模型数据
            Map<String, Object> maps = new HashMap<>();
            maps.put("p", tbItem);
            //生成静态页面, 注意:商品的名称即为静态网页名
            FileWriter w = new FileWriter("G:\\FreeMarker-HTML\\" + tbItem.getId() + ".html");
            template.process(maps, w);
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

