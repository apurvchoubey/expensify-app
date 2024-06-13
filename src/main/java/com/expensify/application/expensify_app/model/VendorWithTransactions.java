package com.expensify.application.expensify_app.model;

import lombok.Data;

import java.util.List;
@Data
public class VendorWithTransactions extends Vendor {
    private String id;
    private String name;
    private String email;
    private List<Transaction> transactions;

}