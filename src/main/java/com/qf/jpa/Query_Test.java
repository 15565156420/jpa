package com.qf.jpa;

import com.qf.service.QueryStudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author lx
 * @Date Create is 2018/1/27 15:29
 * @Modifyed By
 * @Description
 */
public class Query_Test {


    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
        QueryStudentService service=context.getBean(QueryStudentService.class);
        //service.update2();
        System.out.println("方法名查询："+service.getId(33l));
        System.out.println("JPQL查询："+service.query1());
        service.update1("班长",3l);
        System.out.println("原生SQL查询："+service.query2());

        System.out.println("命名查询："+service.query3());
        System.out.println("命名查询2"+service.queryStudent7());
        System.out.println("动态查询："+service.query4("5"));
        System.out.println();



    }
}
