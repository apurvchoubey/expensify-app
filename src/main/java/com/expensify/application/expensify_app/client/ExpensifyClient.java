package com.expensify.application.expensify_app.client;
import com.expensify.application.expensify_app.client.DTOs.Credentials;
import com.expensify.application.expensify_app.client.DTOs.RequestJobDescription;
import com.expensify.application.expensify_app.model.VendorWithTransactions;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Base64;

@Service
public class ExpensifyClient {

    @Value("${expensify.api.server-url}")
    private String baseUrl;

    @Value("${expensify.api.partneruserid}")
    private String partnerUserID;

    @Value("${expensify.api.partnersecret}")
    private String partnerUserSecret;

    private final RestTemplate restTemplate = new RestTemplate();

    private Credentials getCredentials() {
        Credentials credentials = new Credentials();
        credentials.setPartnerUserID(partnerUserID);
        credentials.setPartnerUserSecret(partnerUserSecret);
        return credentials;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public VendorWithTransactions[] getVendorsWithTransactions() throws IOException {
        RequestJobDescription requestJobDescription = getRequestJobDescription();
        HttpEntity<RequestJobDescription> entity = new HttpEntity<>(requestJobDescription, getHeaders());
        ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/vendors", HttpMethod.POST, entity, String.class);
        ObjectMapper mapper = new ObjectMapper();

        VendorWithTransactions[] vendors = mapper.readValue(response.getBody(), VendorWithTransactions[].class);
        return vendors;
    }

    private RequestJobDescription getRequestJobDescription() {
        RequestJobDescription requestJobDescription = new RequestJobDescription();
        requestJobDescription.setCredentials(getCredentials());
        requestJobDescription.setType("get");
        return requestJobDescription;
    }
}