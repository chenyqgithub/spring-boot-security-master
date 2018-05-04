package com.master.spring.security.dao;

import com.master.spring.security.domain.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public SysUser findByUserName(String username);
}
