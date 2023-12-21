package com.example.tuanvm4rest.Controller;

import com.example.tuanvm4rest.Entity.CustomerNameEntity;
import com.example.tuanvm4rest.Service.CustomerNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer-names")
@RequiredArgsConstructor
public class CustomerNameController {

    private final CustomerNameService customerNameService;

    @GetMapping
    public ResponseEntity<List<CustomerNameEntity>> getAllCustomerNames() {
        List<CustomerNameEntity> customerNames = customerNameService.getAllCustomerNames();
        return new ResponseEntity<>(customerNames, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerNameEntity> getCustomerNameById(@PathVariable Integer id) {
        CustomerNameEntity customerName = customerNameService.getCustomerNameById(id);
        if (customerName != null) {
            return new ResponseEntity<>(customerName, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CustomerNameEntity> saveCustomerName(@RequestBody CustomerNameEntity customerName) {
        CustomerNameEntity savedCustomerName = customerNameService.saveCustomerName(customerName);
        return new ResponseEntity<>(savedCustomerName, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerName(@PathVariable Integer id) {
        customerNameService.deleteCustomerName(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
