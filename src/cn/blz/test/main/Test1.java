package cn.blz.test.main;

import cn.blz.test.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        OrderService service =  ctx.getBean("orderService", OrderService.class);
        System.out.println(service.getOrders());
        System.out.println("-------------------------分割线-----------------------");
        System.out.println(service.getOrdersDynamic());
        System.out.println("-------------------------分割线-----------------------");
        System.out.println(service.getOrdersBatch());
    }

    public static void main(String[] args) {
        new Test1().test();
    }
}
