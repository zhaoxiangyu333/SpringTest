package cn.blz.demo.user.dao;

import org.springframework.context.ApplicationContext;

import java.util.Locale;

public class UserDaoImp implements UserDao {
    @Override
    public String sayHello(ApplicationContext ctx, String name) {
        Locale locale = Locale.getDefault();
        String s = ctx.getMessage("hello", new String[]{name}, locale);
        return s;
    }
}
