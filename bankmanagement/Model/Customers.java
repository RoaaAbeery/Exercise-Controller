package com.example.bankmanagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customers {
    private String id;
    private String Username;
    private double balance;
}
