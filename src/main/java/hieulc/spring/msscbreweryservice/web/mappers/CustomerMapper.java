package hieulc.spring.msscbreweryservice.web.mappers;

import hieulc.spring.msscbreweryservice.domains.Customer;
import hieulc.spring.msscbreweryservice.web.models.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
