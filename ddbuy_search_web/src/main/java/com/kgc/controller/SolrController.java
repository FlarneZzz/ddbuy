package com.kgc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.service.SolrService;
import com.kgc.util.PageUitl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class SolrController {
    @Reference(interfaceClass = SolrService.class, timeout = 100000)
    private SolrService solrService;

    @RequestMapping("/import")
    @ResponseBody
    public String importIndex() {
        boolean flag = solrService.importIndex();
        return flag + "";
    }

    //接受页码+查询条件
    @RequestMapping("/Search")
    public String search(String condition, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, Model model) {
        System.out.println("查询条件是:" + condition + ",,,,页码是:" + pageNum);
        //调用业务
        Map<String, Object> map = solrService.searchProduct(condition, pageNum);
        model.addAttribute("map", map);
        model.addAttribute("condition", condition);
        String navigateStr = PageUitl.build(pageNum, (int) map.get("totalPage"), 15);
        model.addAttribute("navigateStr", navigateStr);
        model.addAttribute("pageNum",pageNum);
        return "SearchList";

    }
}
