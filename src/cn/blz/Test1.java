package cn.blz;

import cn.blz.demo.order.service.OrderService;
import cn.blz.demo.user.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    ApplicationContext ctx = null;

    public static void main(String[] args) {
        new Test1().test();
    }

    public Test1() {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
    }

    public void test() {
        OrderService orderService = ctx.getBean("OrderService", OrderService.class);
        UserService userService = ctx.getBean("UserService", UserService.class);
        System.out.println(orderService.getOrders());
        System.out.println(orderService.getOrdersDynamic());
        System.out.println(orderService.getOrdersBatch());
        System.out.println(userService.sayHello("张三"));
    }



}
