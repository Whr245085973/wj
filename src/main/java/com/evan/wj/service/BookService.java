package com.evan.wj.service;

import com.evan.wj.dao.BookDAO;
import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;
    @Autowired
    CategoryService categoryService;
    /**
     * @description: 搜索框查询图书
     * @param keywords
     * @return java.util.List<com.evan.wj.pojo.Book>
     * @author Mr.Wu
     * @date 2019/10/8 13:18
     */
    public List<Book> Search(String keywords) {
        return bookDAO.findAllByTitleLikeOrAuthorLike('%' + keywords + '%','%' + keywords + '%');
    }

    /**
     * @description: 展示图书（排序）
     * @param
     * @return java.util.List<com.evan.wj.pojo.Book>
     * @author Mr.Wu
     * @date 2019/10/8 13:14
     */
    public List<Book> list(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return bookDAO.findAll(sort);
    }
    /**
     * @description: 添加或者修改图书
     * @param book
     * @return void
     * @author Mr.Wu
     * @date 2019/10/8 13:12
     */
    public void addOrUpdate(Book book) {
        bookDAO.save(book);
    }
    /**
     * @description: 根据id删除图书
     * @param id
     * @return void
     * @author Mr.Wu
     * @date 2019/10/8 13:13
     */
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }
    /**
     * @description:  分类查询图书
     * @param cid 
     * @return java.util.List<com.evan.wj.pojo.Book>
     * @author Mr.Wu
     * @date 2019/9/27 14:02
     */
    public List<Book> listByCategory(int cid){
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return bookDAO.findAllByCategory(category);
    }
}
