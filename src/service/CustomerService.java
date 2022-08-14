package service;

import domain.Customer;

import java.util.Map;

public class CustomerService {
    public static Customer getCustomerByKey(Map<String, Customer> customers, String key) {
        for (Map.Entry<String, Customer> customersAux: customers.entrySet()) {
            if (customersAux.getKey().equals(key)) {
                return customersAux.getValue();
            }
        }
        return null;
    }
}