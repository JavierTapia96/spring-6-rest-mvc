package udemy.course.spring6restmvc.mappers;

import org.mapstruct.Mapper;
import udemy.course.spring6restmvc.entities.Customer;
import udemy.course.spring6restmvc.model.CustomerDTO;

/**
 * Created by Javier Tapia on 30/12/2023
 */
@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO customerDTO);

    CustomerDTO customerToCustomerDto(Customer customer);
}
