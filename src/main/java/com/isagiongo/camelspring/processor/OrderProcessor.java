package com.isagiongo.camelspring.processor;

import com.isagiongo.camelspring.dto.Order;
import com.isagiongo.camelspring.service.OrderService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor implements Processor {

    private OrderService orderService;

    public OrderProcessor(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        orderService.addOrder(exchange.getIn().getBody(Order.class));
    }
}
