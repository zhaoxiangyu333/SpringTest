package cn.blz.demo.order.service;

import cn.blz.demo.order.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("OrderService")
public class OrderService {

    private OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Map> getOrders() {
        return orderDao.getOrders(new HashMap());
    }

    public List<Map> getOrdersDynamic(){
        return orderDao.getOrdersDynamic(new HashMap());
    }

    public List<Map> getOrdersBatch(){
        return orderDao.getOrdersBatch(new ArrayList());
    }


}
