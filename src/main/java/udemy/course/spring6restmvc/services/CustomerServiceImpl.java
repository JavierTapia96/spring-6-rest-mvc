package udemy.course.spring6restmvc.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import udemy.course.spring6restmvc.model.CustomerDTO;

/**
 * Created by Javier Tapia on 25/11/2023
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        CustomerDTO customer1 = CustomerDTO.builder()
                                           .id(UUID.randomUUID())
                                           .version(1)
                                           .customerName("Javier Tapia")
                                           .createdDate(LocalDateTime.now())
                                           .lastModifiedDate(LocalDateTime.now())
                                           .build();

        CustomerDTO customer2 = CustomerDTO.builder()
                                           .id(UUID.randomUUID())
                                           .version(1)
                                           .customerName("Nicole Tapia")
                                           .createdDate(LocalDateTime.now())
                                           .lastModifiedDate(LocalDateTime.now())
                                           .build();

        CustomerDTO customer3 = CustomerDTO.builder()
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
    public List<CustomerDTO> listCustomers() {
        log.debug("Listing customers - In service...");
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        log.debug("Getting customer by id - In service...");
        return Optional.of(customerMap.get(id));
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customer) {
        log.debug("Saving new customer - In service...");
        CustomerDTO savedCustomer = CustomerDTO.builder()
                                               .id(UUID.randomUUID())
                                               .version(1)
                                               .customerName(customer.getCustomerName())
                                               .createdDate(LocalDateTime.now())
                                               .lastModifiedDate(LocalDateTime.now())
                                               .build();
        customerMap.put(savedCustomer.getId(), savedCustomer);
        return savedCustomer;
    }

    @Override
    public void updateCustomerById(UUID id, CustomerDTO customer) {
        log.debug("Updating customer by id - In service...");
        CustomerDTO existingCustomer = customerMap.get(id);
        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setLastModifiedDate(LocalDateTime.now());

        customerMap.put(id, existingCustomer);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("Deleting customer by id - In service...");
        customerMap.remove(id);
    }

    @Override
    public void patchCustomerById(UUID id, CustomerDTO customer) {
        CustomerDTO existingCustomer = customerMap.get(id);

        if (StringUtils.hasText(customer.getCustomerName())) {
            existingCustomer.setCustomerName(customer.getCustomerName());
        }
    }
}
