package com.improvemyskills.orderservice.web;

import com.improvemyskills.orderservice.clients.CustomerRestClient;
import com.improvemyskills.orderservice.models.Customer;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {
    CustomerRestClient customerRestClient;

    public OrderController(CustomerRestClient customerRestClient) {
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/customers")
    public ResponseEntity<PagedModel<Customer>> getCustomerRestClient() {
        return new ResponseEntity<>(customerRestClient.getAllCustomers(), HttpStatus.OK);
    }
}
