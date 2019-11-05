package com.evan.wj.service;

import com.evan.wj.dao.UpdatecardDAO;
import com.evan.wj.pojo.Updatecard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @description:
 * @author: Mr.Wu
 * @create: 2019/11/5 13:06
 **/
@Service
public class UpdatecardService {
    @Autowired
    UpdatecardDAO updatecardDAO;
    /**
     JPA中有一种分页接口，利用Pageable对我们findAll出来的数据进行分页排序。
     */
    public List<Updatecard> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "date");
        Pageable pageable = PageRequest.of(0, 5,sort);
        Page<Updatecard> updatecardsPage = updatecardDAO.findAll(pageable);
        List<Updatecard> updatecards = updatecardsPage.getContent();
        return updatecards;
    }
    /**
     * 创建分页请求.(根据不同排序类型进行排序)
     */
    private Pageable buildPageRequest(int pageNumber, int pagzSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.DESC, "date");
        } else if ("title".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "title");
        }
        return PageRequest.of(pageNumber - 1, pagzSize, sort);
    }


}
