package com.kgc.mapper;

import com.kgc.entity.AdminUsers;
import com.kgc.entity.AdminUsersExample;

import java.util.List;

public interface AdminUsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdminUsers record);

    int insertSelective(AdminUsers record);

    List<AdminUsers> selectByExample(AdminUsersExample example);

    AdminUsers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminUsers record);

    int updateByPrimaryKey(AdminUsers record);
}