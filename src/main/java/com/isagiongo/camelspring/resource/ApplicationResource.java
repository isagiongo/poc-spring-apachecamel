package com.isagiongo.camelspring.resource;

import com.isagiongo.camelspring.dto.Order;
import com.isagiongo.camelspring.processor.OrderProcessor;
import com.isagiongo.camelspring.service.OrderService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ApplicationResource extends RouteBuilder {

    private OrderService orderService;

    private OrderProcessor orderProcessor;

    public ApplicationResource(OrderService orderService, OrderProcessor orderProcessor) {
        this.orderService = orderService;
        this.orderProcessor = orderProcessor;
    }

    @Override
    public void configure() throws Exception {
        restConfiguration()
                .component("servlet")
                .port(9090)
                .host("localhost")
                .bindingMode(RestBindingMode.json);

        rest()
                .get("/hello-world")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .route()
                .setBody(constant("Oi turo pom?"))
        .endRest();

        rest()
                .get("/getOrders")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .route()
                .setBody(() -> orderService.getOrders())
        .endRest();

        rest()
                .post("/addOrder")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .type(Order.class)
                .outType(Order.class)
                .route()
                .process(orderProcessor)
                .endRest();
    }
}
