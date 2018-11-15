package com.yyp.test;

import com.yyp.dao.ItemsDao;
import com.yyp.service.ItemsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Yang
 * @version V 1.0
 * @date 2018-11-07
 */

public class ItemsDaoTest {

/*
    @Test
    public void findById() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ItemsDao itemsDao = ac.getBean(ItemsDao.class);
        System.out.println(itemsDao.findById(1));
    }
*/

    @Test
    public void findById() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ItemsService itemsService = ac.getBean(ItemsService.class);
        System.out.println(itemsService.findById(1));
    }
}
