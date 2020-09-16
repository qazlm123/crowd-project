package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.Menu;
import com.atguigu.crowd.entity.MenuExample;
import com.atguigu.crowd.mapper.MenuMapper;
import com.atguigu.crowd.service.api.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Override
    public void updateMenu(Menu menu) {

        // pid没有传入不会更新父节点，一点要使用有选择的更新，保证pid不会被置空
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public void removeMenu(Integer id) {

        menuMapper.deleteByPrimaryKey(id);
    }

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getAll() {

        return  menuMapper.selectByExample(new MenuExample());

    }

    @Override
    public void saveMenu(Menu menu) {

        menuMapper.insert(menu);
    }
}
