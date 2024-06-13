package com.expensify.application.expensify_app.client.DTOs;

import lombok.Data;
import net.minidev.json.JSONArray;

@Data
public class InputSettings {
        private String type;

        private String[] fields;

        private String userEmail;

        private String[] policyIDList;
}
