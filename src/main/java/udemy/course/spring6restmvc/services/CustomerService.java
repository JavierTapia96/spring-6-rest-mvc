package udemy.course.spring6restmvc.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import udemy.course.spring6restmvc.model.CustomerDTO;

/**
 * Created by Javier Tapia on 25/11/2023
 */
public interface CustomerService {

    List<CustomerDTO> listCustomers();

    Optional<CustomerDTO> getCustomerById(UUID id);

    CustomerDTO saveNewCustomer(CustomerDTO customer);

    void updateCustomerById(UUID id, CustomerDTO customer);

    void deleteById(UUID id);

    void patchCustomerById(UUID id, CustomerDTO customer);
}
