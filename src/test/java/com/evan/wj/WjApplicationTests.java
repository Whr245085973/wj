package com.evan.wj;

import com.evan.wj.dao.UpdatecardDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WjApplicationTests {

    @Autowired
    UpdatecardDAO updatecardDAO;

    @Test
    public void contextLoads() {



    }
    @Test
    public void test(){
        int flag = 0;
        /*if(flag!=3 && flag==2){
            System.out.println("test");
        }else if (flag!=3 && flag!=2){
            System.out.println("2");
        }*/

        if(flag!=3){

            if (flag == 2){
                System.out.println("test");
            }else{
                System.out.println("2");
            }
        }
    }

}
