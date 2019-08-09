package com.kgc.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TbUserController {
    @Reference(interfaceClass = TbUserService.class)
    private TbUserService tbUserService;

    //用户登录后 如果数据库有该用户 生成一个UUID 随机数当做redis的Key,这个TbUser当做值存在redis并返回这个UUID token
    @RequestMapping("/login")
    public String login(String username, String password, HttpServletResponse response){
        String token = tbUserService.login(username, password);
        if (token==null){
            return "Login";
        }else{
            Cookie cookie = new Cookie("token",token);
            cookie.setPath("/");//解决cookie不同子系统的跨域问题
            cookie.setMaxAge(1200);//1200秒 20分钟
            response.addCookie(cookie);
            return "ok";
        }
    }
    //发请求获取用户名
    @RequestMapping("/getUserName")
    @ResponseBody
    @CrossOrigin //支持跨域
    public Map<String,String> getUserName(String token){
        String username = tbUserService.getUsername(token);
        Map<String,String> map=new HashMap<>();
        map.put("result",username);
        return map;
    }
}
