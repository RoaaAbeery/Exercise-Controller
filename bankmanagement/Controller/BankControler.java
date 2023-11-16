package com.example.bankmanagement.Controller;

import com.example.bankmanagement.API.APi;
import com.example.bankmanagement.Model.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/ap1/v1/Bank")
public class BankControler {
    ArrayList<Customers> customers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customers> getTasks() {
        return customers;
    }

    @PostMapping("/add")
    public APi addTasks(@RequestBody Customers customer) {
        customers.add(customer);
        return new APi("Customer add", 200);

    }

    @PutMapping("/update/{index}")
    public APi updateTasks(@PathVariable int index, @RequestBody Customers customer) {
        customers.set(index, customer);
        return new APi("Customer updated", 200);
    }


    @DeleteMapping("/delete/{index}")
    public APi deleteTasks(@PathVariable int index) {
        customers.remove(index);
        return new APi("Customer deleted", 200);
    }
    @PutMapping("/deposit/{index}")
    public APi depositMoney(@PathVariable int index, @RequestBody double amount) {
        if (amount>0) {
            customers.get(index).setBalance(customers.get(index).getBalance() + amount);
            return new APi("Money deposited", 200);
        }
        return new APi("amount invalid", 404);
    }
    @PutMapping("/withdraw/{index}")
    public APi withdrawMoney(@PathVariable int index, @RequestBody double amount) {
        if (amount>0&& amount<customers.get(index).getBalance()) {
            customers.get(index).setBalance(customers.get(index).getBalance() - amount);
            return new APi("Money withdrawn", 200);
        }
            return new APi("Insufficient funds", 400);
        
    }
}
