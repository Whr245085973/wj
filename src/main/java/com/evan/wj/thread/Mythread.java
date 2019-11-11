package com.evan.wj.thread;

import com.evan.wj.dao.UpdatecardDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: Mr.Wu
 * @create: 2019/11/7 17:19
 **/
public class Mythread {

    @Autowired
    public static UpdatecardDAO updatecardDAO;



    public static void main(String[] args) {

        //转换提日期输出格式
        String[] strNow3 = new SimpleDateFormat("HH:mm:ss").format(new Date()).toString().split(":");

        Integer hour = Integer.parseInt(strNow3[0]);			//获取时（24小时制）
        Integer minute = Integer.parseInt(strNow3[1]);			//获取分
        Integer second = Integer.parseInt(strNow3[2]);			//获取秒

        if (hour ==14) {
            System.out.println("开始执行转移数据库线程！");
            /*Mythread thread = new Mythread();
            Thread Thread1=new Thread(thread,"线程1");
            Thread1.start();
            System.out.println("程序执行结束。");
            */
            ExecutorService ex= Executors.newSingleThreadExecutor();
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程");

                }
            });
            ex.shutdown();
        }
    }

}
