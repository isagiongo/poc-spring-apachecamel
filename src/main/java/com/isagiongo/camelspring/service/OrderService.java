package com.isagiongo.camelspring.service;

import com.isagiongo.camelspring.dto.Order;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private List<Order> listOrder = new ArrayList<>();

    @PostConstruct
    public void initDB() {

        listOrder.add(new Order(67, "Mobile", 5000));
        listOrder.add(new Order(89, "Book", 120));
        listOrder.add(new Order(45, "Shoes", 90));
    }

    public Order addOrder(Order order) {
        listOrder.add(order);
        return order;
    }

    public List<Order> getOrders() {
        return listOrder;
    }
}
