package com.expensify.application.expensify_app.client;
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

    @Value("${expensify.api.url}")
    private String baseUrl;

    @Value("${expensify.api.key}")
    private String apiKey;

    @Value("${expensify.api.secret}")
    private String apiSecret;

    private final RestTemplate restTemplate = new RestTemplate();

    private String getAuthorizationHeader() {
        String credentials = apiKey + ":" + apiSecret;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        return "Basic " + encodedCredentials;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", getAuthorizationHeader());
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public VendorWithTransactions[] getVendorsWithTransactions() throws IOException {
        HttpEntity<String> entity = new HttpEntity<>("", getHeaders());
        ResponseEntity<String> response = restTemplate.exchange(baseUrl + "/vendors", HttpMethod.GET, entity, String.class);
        ObjectMapper mapper = new ObjectMapper();

        // Map to VendorWithTransactions class
        VendorWithTransactions[] vendors = mapper.readValue(response.getBody(), VendorWithTransactions[].class);
        return vendors;
    }
}