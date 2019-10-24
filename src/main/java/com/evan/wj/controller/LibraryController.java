package com.evan.wj.controller;

import com.evan.wj.pojo.Book;
import com.evan.wj.pojo.Search;
import com.evan.wj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @description: 图书馆
 * @author: Mr.Wu
 * @create: 2019/9/27 14:05
 **/
@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @CrossOrigin
    @PostMapping("/api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        //测试环境windows版
        String folder = "D:/workspace/img";
        //生产环境Linux版
        //String folder = "/usr/local/src/data/wj/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            //测试环境windows版
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            //生产环境Linux版
            //String imgURL = "http://47.103.32.110:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    @CrossOrigin
    @PostMapping("/api/search")
    public List<Book> searchResult(@RequestBody Search s) throws Exception {
        // 关键字为空时查询所有书籍
        if ("".equals(s.getKeywords())) {
            return bookService.list();
        } else {
            return bookService.Search(s.getKeywords());
        }
    }

    @CrossOrigin
    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @CrossOrigin
    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @CrossOrigin
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid){
            return bookService.listByCategory(cid);
        }else {
            return list();
        }
    }
}
