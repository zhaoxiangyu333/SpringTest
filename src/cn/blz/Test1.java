package cn.blz;

import cn.blz.demo.order.service.OrderService;
import cn.blz.demo.user.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class Test1 {
    ApplicationContext ctx = null;

    public static void main(String[] args) {
        new Test1().test();
    }

    public Test1() {
        ctx = new ClassPathXmlApplicationContext("spring/order.xml",
                "spring/user.xml",
                "spring/messageSource.xml");
    }

    public void test() {
        OrderService orderService = ctx.getBean("orderService", OrderService.class);
        UserService userService = ctx.getBean("userService", UserService.class);
//        System.out.println(orderService.getOrders());
//        System.out.println(orderService.getOrdersDynamic());
//        System.out.println(orderService.getOrdersBatch());
        System.out.println(userService.sayHello("张三"));
    }



}
