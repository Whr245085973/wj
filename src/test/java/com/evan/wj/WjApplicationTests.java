package com.evan.wj;

import com.evan.wj.dao.UpdatecardDAO;
import com.evan.wj.pojo.Updatecard;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WjApplicationTests {

    @Autowired
    UpdatecardDAO updatecardDAO;

    @Test
    public void contextLoads() {
        log.info("123");
        System.out.println("开始");
        log.info("456");
    }
    @Test
    public void test(){
        List<Updatecard> name = updatecardDAO.findAll();
        if (name!=null){
            System.out.println("1");
        }
    }

}
