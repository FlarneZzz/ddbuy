package com.kgc;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerTest {
    public static void main(String[] args)throws Exception {
        //利用FreeMarker生成静态页面的步骤
        //1.导入依赖
        //2.生成静态页面的步骤
        //2.1创建Configuration对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        //2.2设置相关参数
        //设置编码
        configuration.setDefaultEncoding("utf-8");
        //2.3设置模板目录
        File file = new File("G:\\IdeaMode\\ddbuy_parent\\ddbuy_freemarker_test\\src\\main\\resources");
        configuration.setDirectoryForTemplateLoading(file);
        //2.3获取模板对象
        Template template = configuration.getTemplate("first.ftl");
        //2.4创建模板对应的模型数据
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("name", "隔壁老王");
        maps.put("content", "冲啊,弟弟们");
        maps.put("names", Arrays.asList("李老八", "阿布多", "于超"));
        //2.5生成静态页面
        FileWriter w = new FileWriter("G:\\IdeaMode\\ddbuy_parent\\ddbuy_freemarker_test\\src\\main\\resources\\auto.html");
        template.process(maps,w);
        w.close();
        System.out.println("生成静态页面成功");

    }
}
