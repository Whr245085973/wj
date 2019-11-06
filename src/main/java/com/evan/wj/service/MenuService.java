package com.evan.wj.service;

import com.evan.wj.dao.MenuDAO;
import com.evan.wj.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Mr.Wu
 * @create: 2019/11/6 15:28
 **/
@Service
public class MenuService {
    @Autowired
    MenuDAO menuDAO;

    public List<Menu> menuList(){
        Sort sort =new Sort(Sort.Direction.ASC,"id");
        List<Menu> menus = menuDAO.findAll(sort);
        return menus;
    }

}
