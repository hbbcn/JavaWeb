package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.User01;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface User01Mapper {

    public User01 getUser(Long id);
}
