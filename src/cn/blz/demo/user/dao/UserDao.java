package cn.blz.demo.user.dao;

import org.springframework.context.ApplicationContext;

public interface UserDao {
    String sayHello(ApplicationContext ctx, String name);
}
