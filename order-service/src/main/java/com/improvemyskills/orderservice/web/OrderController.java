package com.improvemyskills.orderservice.web;

import com.improvemyskills.orderservice.clients.CustomerRestClient;
import com.improvemyskills.orderservice.clients.ProductRestClient;
import com.improvemyskills.orderservice.models.Customer;
import com.improvemyskills.orderservice.models.Product;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    CustomerRestClient customerRestClient;
    ProductRestClient productRestClient;

    public OrderController(CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }

    @GetMapping("/customers")
    public ResponseEntity<PagedModel<Customer>> getCustomerRestClient() {
        return new ResponseEntity<>(customerRestClient.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<Collection<Product>> getProductRestClient() {
        return productRestClient.getAll();
    }



}
