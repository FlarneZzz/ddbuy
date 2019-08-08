package com.kgc.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.service.TbItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TbItemController {
    @Reference(interfaceClass = TbItemService.class,timeout = 1000000)
    private TbItemService tbItemService;

    @RequestMapping("/processHtml")
    @ResponseBody
    public String processHtml(){
        return tbItemService.processHtml()+"";
    }
}
