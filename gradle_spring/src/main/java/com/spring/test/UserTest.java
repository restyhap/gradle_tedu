package com.spring.test;


import cn.tedu.primary.SwingDemo;
import com.spring.bean.User;
import com.spring.di.IBookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author restyhap
 * @date 2019年03月02日 00:01
 * <pre>
 *
 * </pre>
 */
public class UserTest {
    @Test
    public void demo1(){
        User user = new User();
        user.say();
    }
    @Test
    public void demo2(){
        /*当前XML的文件路径*/
        String xmlPath = "beans.xml";
        /*通过路径获取应用的上下文*/
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        /*通过getBean(String name)来获取实例.
         * String name == xml里面bean的id
         * */
        User user = (User) applicationContext.getBean("userID");
        /*调用实例的方法*/
        user.say();
    }
    /**测试导模块的实例*/
    @Test
    public void demo3(){
        SwingDemo sd = new SwingDemo();
        sd.say();
    }
    /**测试简单DI*/
    @Test
    public void demo4(){
        String xmlPath = "beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        User user = (User) applicationContext.getBean("userID");
        System.out.println(user.getName());
    }

    /**
     * 测试IBook实例
     */
    @Test
    public void demo5(){
        String xmlPath = "beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        IBookService ibs = (IBookService) applicationContext.getBean("iBookServiceID");
        ibs.addBook();
    }
    
}
