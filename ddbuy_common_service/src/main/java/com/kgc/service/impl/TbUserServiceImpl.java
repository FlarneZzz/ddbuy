package com.kgc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kgc.entity.TbUser;
import com.kgc.entity.TbUserExample;
import com.kgc.mapper.TbUserMapper;
import com.kgc.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service(interfaceClass = TbUserService.class)
@Component
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public String login(String username, String password) {
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria criteria = tbUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
        if(tbUsers.size()==1){
            //生成token,唯一,使用uuid生成
            String tooken = UUID.randomUUID().toString();
            ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
            valueOperations.set("session:"+tooken,tbUsers.get(0),20,TimeUnit.MINUTES);
            return tooken;
        }else{
            return null;
        }
    }

    @Override
    public String getUsername(String tooken) {
        if(this.redisTemplate.hasKey("session:"+tooken)){
            ValueOperations<String,Object> valueOperations = this.redisTemplate.opsForValue();
            TbUser tbUser = (TbUser) valueOperations.get("session:" + tooken);
            return tbUser.getUsername();
        }
        else{
            return "";
        }
    }
}
