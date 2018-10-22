package cn.blz.demo.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository("UserDao")
public class UserDaoImp implements UserDao {
    @Override
    public String sayHello(ApplicationContext ctx, String name) {
        Locale locale = Locale.getDefault();
        String s = ctx.getMessage("hello", new String[]{name}, locale);
        return s;
    }
}
