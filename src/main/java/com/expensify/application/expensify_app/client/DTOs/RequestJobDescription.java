package com.expensify.application.expensify_app.client.DTOs;

import lombok.Data;

@Data
public class RequestJobDescription {
    private String type;

    private Credentials credentials;

    private InputSettings inputSettings;
}
