package com.evan.wj.service;

import com.evan.wj.dao.CategoryDAO;
import com.evan.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;
    /**
     *功能描述
     * @author Mr.Wu
     * @date 2019/9/27
     * @param
     * @return java.util.List<com.evan.wj.pojo.Category>
     */
    public List<Category> list(){
        //针对查询结果的id做了一个降序
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }
    /**
     *功能描述
     * @author Mr.Wu
     * @date 2019/9/27
     * @param id
     * @return com.evan.wj.pojo.Category
     */
    public Category get(int id){

        Category c = categoryDAO.findById(id).orElse(null);
        return c;
    }
}
