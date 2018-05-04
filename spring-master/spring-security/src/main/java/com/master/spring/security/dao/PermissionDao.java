package com.master.spring.security.dao;

import com.master.spring.security.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yangyibo on 17/1/20.
 */
@Repository
public interface PermissionDao {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(int userId);
}
