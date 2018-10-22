package cn.blz.demo.user.service;

import cn.blz.demo.user.dao.UserDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService implements ApplicationContextAware {
    private ApplicationContext ctx = null;
    private UserDao userDao = null;

    @Autowired
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
