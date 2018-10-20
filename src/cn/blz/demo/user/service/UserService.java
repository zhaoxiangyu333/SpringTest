package cn.blz.demo.user.service;

import cn.blz.demo.user.dao.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class UserService implements ApplicationContextAware {
    private ApplicationContext ctx = null;
    private UserDao userDao = null;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public String sayHello(String name) {
        return userDao.sayHello(ctx, name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
