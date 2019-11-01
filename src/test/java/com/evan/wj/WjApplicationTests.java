package com.evan.wj;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WjApplicationTests {

    @Test
    public void contextLoads() {
        log.info("123");
        System.out.println("开始");
        log.info("456");
    }

}
