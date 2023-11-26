package udemy.course.spring6restmvc.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import udemy.course.spring6restmvc.model.Customer;

/**
 * Created by Javier Tapia on 25/11/2023
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final Map<UUID, Customer> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        Customer customer1 = Customer.builder()
            .id(UUID.randomUUID())
            .version(1)
            .customerName("Javier Tapia")
            .createdDate(LocalDateTime.now())
            .lastModifiedDate(LocalDateTime.now())
            .build();

        Customer customer2 = Customer.builder()
            .id(UUID.randomUUID())
            .version(1)
            .customerName("Nicole Tapia")
            .createdDate(LocalDateTime.now())
            .lastModifiedDate(LocalDateTime.now())
            .build();

        Customer customer3 = Customer.builder()
            .id(UUID.randomUUID())
            .version(1)
            .customerName("Priscila Villa")
            .createdDate(LocalDateTime.now())
            .lastModifiedDate(LocalDateTime.now())
            .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);
    }

    @Override
    public List<Customer> listCustomers() {
        log.debug("Listing customers - In service...");
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id) {
        log.debug("Getting customer by id - In service...");
        return customerMap.get(id);
    }
}
