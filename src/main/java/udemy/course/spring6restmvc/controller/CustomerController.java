package udemy.course.spring6restmvc.controller;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udemy.course.spring6restmvc.model.Customer;
import udemy.course.spring6restmvc.services.CustomerService;

/**
 * Created by Javier Tapia on 25/11/2023
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer> listCustomers() {
        log.debug("Listing customers - In controller...");
        return customerService.listCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") UUID id) {
        log.debug("Getting customer by id - In controller...");
        return customerService.getCustomerById(id);
    }
}
