package com.improvemyskills.orderservice.clients;

import com.improvemyskills.orderservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}?projection=customer_projection")
    @CircuitBreaker(name = "customerservice", fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable Long id);
    @GetMapping(path = "/customers?projection=customer_projection")
    PagedModel<Customer> getAllCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception){
        return Customer.builder()
                .firstName("UNKNOWN")
                .lastName("UNKNOWN")
                .email("UNKNOWN@improvemyskills.com")
                .build();
    }
}
