package com.expensify.application.expensify_app.service;

import com.expensify.application.expensify_app.client.ExpensifyClient;
import com.expensify.application.expensify_app.model.Transaction;
import com.expensify.application.expensify_app.model.Vendor;
import com.expensify.application.expensify_app.model.VendorWithTransactions;
import com.expensify.application.expensify_app.model.repo.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class VendorService {

    @Autowired
    private ExpensifyClient expensifyClient;

    @Autowired
    private VendorRepository vendorRepository;

    @Scheduled(cron = "0 0 * * * *") // Schedule to run daily at midnight
    public void pullVendorData() throws IOException {
        VendorWithTransactions[] vendors = expensifyClient.getVendorsWithTransactions();
        for (VendorWithTransactions vendor : vendors) {
            vendorRepository.save(vendor); // Saves vendor with Latest Transactions
        }
    }
}