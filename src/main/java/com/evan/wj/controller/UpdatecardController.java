package com.evan.wj.controller;

import com.evan.wj.pojo.Updatecard;
import com.evan.wj.service.UpdatecardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description:
 * @author: Mr.Wu
 * @create: 2019/11/5 11:42
 **/
@Controller
public class UpdatecardController {

    @Autowired
    UpdatecardService updatecardService;
    /**
     * @description:  查询最新更新的几条数据
     * @param
     * @return java.util.List<com.evan.wj.pojo.Updatecard>
     * @author Mr.Wu
     * @date 2019/11/5 14:34
     */
    @GetMapping("api/updatecard")
    @ResponseBody
    public List<Updatecard> find(){
        return updatecardService.list();
    }

}
