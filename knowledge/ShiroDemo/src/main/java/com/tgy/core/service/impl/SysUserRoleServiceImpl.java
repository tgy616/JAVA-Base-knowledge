package com.tgy.core.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tgy.core.dao.SysUserRoleDao;
import com.tgy.core.entity.SysUserRoleEntity;
import com.tgy.core.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * @Description 用户与角色业务实现
 * @Author Sans
 * @CreateTime 2019/6/14 15:57
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {

}