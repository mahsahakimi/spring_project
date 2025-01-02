package edu.sharif.web.customer;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


@Service
// @Component
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

//    private final List<Customer> customers = new ArrayList<>(
//            List.of(
//                    new Customer(1L, "Ali", "ali@xyz.com", LocalDate.of(2003, Month.APRIL, 20), 22),
//                    new Customer(2L, "Sara", "sara@xyz.com", LocalDate.of(2000, Month.DECEMBER, 2), 25)
//            )
//    );

    public List<Customer> getCustomers() {
        return this.customerRepository.findAll();
    }

    @Transactional
    public void addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(
                customerDto.name(),
                customerDto.email(),
                customerDto.dob()
        );
        this.customerRepository.save(customer);
    }

    @Transactional
    public void editCustomer(Long customerId, CustomerDto customerDto) {
        Customer oldCustomer = customerRepository.findById(customerId)
                .orElseThrow(
                        () -> new RuntimeException("Customer with id" + customerId + " not found")
                );

        oldCustomer.setName(customerDto.name());
        oldCustomer.setEmail(customerDto.email());
        oldCustomer.setDob(customerDto.dob());
        this.customerRepository.save(oldCustomer);
    }

    @Transactional
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(
                        () -> new RuntimeException("Customer with email" + email + " not found")
                );
    }

}
