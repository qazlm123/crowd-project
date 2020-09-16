package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.entity.RoleExample;
import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.service.api.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public List<Role> getAssignedRole(Integer adminId) {

       return roleMapper.selectAssignedRole(adminId);
    }

    @Override
    public List<Role> getUnAssignedRole(Integer adminId) {
        return roleMapper.selectUnAssignedRole(adminId);
    }

    @Override
    public void removeRoleList(List<Integer> roleList) {
        RoleExample roleExample = new RoleExample();

        RoleExample.Criteria criteria = roleExample.createCriteria();

        // where id in (5,6,12)

        criteria.andIdIn(roleList);

        roleMapper.deleteByExample(roleExample);
    }

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public PageInfo<Role> getPageInfo(Integer pageNum, Integer pageSize, String keyword) {

        // 1.开启分页的功能
        PageHelper.startPage(pageNum, pageSize);


        // 2.执行查询
        List<Role> roleList= roleMapper.selectRoleByKeyword(keyword);

        //封装为PageInfo对象返回
        return new PageInfo<>(roleList);
    }

    @Override
    public void saveRole(Role role) {
        roleMapper.insert(role);
    }

}