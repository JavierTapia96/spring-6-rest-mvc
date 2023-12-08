package udemy.course.spring6restmvc.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import udemy.course.spring6restmvc.model.Customer;

/**
 * Created by Javier Tapia on 25/11/2023
 */
public interface CustomerService {

    List<Customer> listCustomers();

    Optional<Customer> getCustomerById(UUID id);

    Customer saveNewCustomer(Customer customer);

    void updateCustomerById(UUID id, Customer customer);

    void deleteById(UUID id);

    void patchCustomerById(UUID id, Customer customer);
}
