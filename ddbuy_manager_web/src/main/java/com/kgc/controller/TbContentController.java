package com.kgc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.entity.TbContent;
import com.kgc.service.TbContentService;
import com.kgc.util.FastDfsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class TbContentController {
    @Autowired
   private FastDfsUtil fastDfsUtil;
    @Reference(interfaceClass = TbContentService.class)
    private TbContentService tbContentService;
    @RequestMapping("/addContent")
    public String addContent(@RequestParam(value = "picfile")MultipartFile multipartFile, TbContent tbContent){
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            String expname = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            System.out.println(expname);
            String saveFileName = fastDfsUtil.uploadFile(multipartFile.getBytes(), expname);
            System.out.println(saveFileName);
            if (saveFileName!=null){
                tbContent.setPic(saveFileName);
                tbContentService.addContent(tbContent);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"result\":0}";
        }
        return "{\"result\":1}";
    }
}
