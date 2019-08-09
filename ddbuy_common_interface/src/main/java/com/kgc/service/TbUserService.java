package com.kgc.service;

public interface TbUserService {
    /**
     * @param username 用户名
     * @param password 密码
     * @return 返回tooken
     */
    public String login(String username,String password);

    /**
     *
     * @param tooken 令牌
     * @return 返回用户名
     */
    public String getUsername(String tooken);
}
