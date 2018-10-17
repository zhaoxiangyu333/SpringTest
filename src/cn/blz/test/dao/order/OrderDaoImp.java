package cn.blz.test.dao.order;

import cn.blz.test.dto.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDaoImp implements OrderDao {
    SqlSessionFactory factory = null;
    SqlSession session = null;

    public OrderDaoImp() {
        InputStream stream = null;
        try {
            stream = Resources.getResourceAsStream("config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(stream);
    }

    @Override
    public List<Map> getOrders(Map args) {
        session = factory.openSession();
        OrderDao mapper = session.getMapper(OrderDao.class);
        User user = new User();
        user.setCname("李工");
        args.put("user", user);
        List<Map> list = mapper.getOrders(args);
        session.close();
        return list;
    }

    @Override
    public List<Map> getOrdersDynamic(Map args) {
        session = factory.openSession();
        OrderDao mapper = session.getMapper(OrderDao.class);
        User user = new User();
        user.setCname("李");
        args.put("user", user);
        args.put("state",2);
        List<Map> list = mapper.getOrdersDynamic(args);
        session.close();
        return list;
    }

    @Override
    public List<Map> getOrdersBatch(List list) {
        session = factory.openSession();
        OrderDao mapper = session.getMapper(OrderDao.class);
        list.add("US00000001");
        list.add("US00000002");
        List<Map> list2 = mapper.getOrdersBatch(list);
        session.close();
        return list2;
    }
}
