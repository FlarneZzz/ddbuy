package com.kgc.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.entity.TbContent;
import com.kgc.service.TbContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Reference(interfaceClass = TbContentService.class)
    private TbContentService tbContentService;
    //获取所有广告
    @RequestMapping("/goIndex")
    public String goIndex(Model model){
        List<TbContent> allTbContent = tbContentService.getAllTbContent();
        model.addAttribute("allTbContent",allTbContent);
        return "Index";
    }
}
