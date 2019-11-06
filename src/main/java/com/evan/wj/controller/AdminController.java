package com.evan.wj.controller;

import com.evan.wj.pojo.Menu;
import com.evan.wj.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description:
 * @author: Mr.Wu
 * @create: 2019/11/6 15:38
 **/
@Controller
public class AdminController {
    @Autowired
    MenuService menuService;

    @GetMapping("api/menu")
    @ResponseBody
    public List<Menu> list(){
        return menuService.menuList();
    }

}
