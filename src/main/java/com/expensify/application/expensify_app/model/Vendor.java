package com.expensify.application.expensify_app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "vendors")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Vendor {
    private String id;

    private String name;

    private List<Transaction> transactionList;

    private String email;

}
