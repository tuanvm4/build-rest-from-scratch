package com.example.tuanvm4rest.Service;

import com.example.tuanvm4rest.Entity.CustomerNameEntity;
import com.example.tuanvm4rest.Repository.CustomerNameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerNameService {
    private final CustomerNameRepository customerNameRepository;

    public List<CustomerNameEntity> getAllCustomerNames() {
        return customerNameRepository.findAll();
    }

    public CustomerNameEntity getCustomerNameById(Integer id) {
        return customerNameRepository.findById(id).orElse(null);
    }

    public CustomerNameEntity saveCustomerName(CustomerNameEntity customerName) {
        return customerNameRepository.save(customerName);
    }

    public void deleteCustomerName(Integer id) {
        customerNameRepository.deleteById(id);
    }

}
