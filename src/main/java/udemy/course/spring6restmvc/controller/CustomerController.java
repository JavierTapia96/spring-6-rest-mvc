package udemy.course.spring6restmvc.controller;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import udemy.course.spring6restmvc.model.Customer;
import udemy.course.spring6restmvc.services.CustomerService;

/**
 * Created by Javier Tapia on 25/11/2023
 */
@Slf4j
@AllArgsConstructor
@RestController
public class CustomerController {

    public static final String CUSTOMER_PATH = "/api/v1/customer";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{id}";

    private final CustomerService customerService;

    @PatchMapping(CUSTOMER_PATH_ID)
    public ResponseEntity<?> updateCustomerPatchById(@PathVariable("id") UUID id,
                                                     @RequestBody Customer customer) {
        customerService.patchCustomerById(id, customer);
        log.debug("Patched customer with id: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(CUSTOMER_PATH_ID)
    public ResponseEntity<?> deleteById(@PathVariable("id") UUID id) {
        customerService.deleteById(id);
        log.debug("Deleted customer with id: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(CUSTOMER_PATH_ID)
    public ResponseEntity<?> updateById(@PathVariable("id") UUID id,
                                        @RequestBody Customer customer) {
        customerService.updateCustomerById(id, customer);
        log.debug("Updated customer with id: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(CUSTOMER_PATH)
    public ResponseEntity<?> handlePost(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveNewCustomer(customer);

        log.debug("Saved customer with id: " + savedCustomer.getId());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedCustomer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping(CUSTOMER_PATH)
    public List<Customer> listCustomers() {
        log.debug("Listing customers - In controller...");
        return customerService.listCustomers();
    }

    @GetMapping(CUSTOMER_PATH_ID)
    public Customer getCustomerById(@PathVariable("id") UUID id) {
        log.debug("Getting customer by id - In controller...");
        return customerService.getCustomerById(id);
    }
}
