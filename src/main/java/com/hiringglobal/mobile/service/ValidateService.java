package com.hiringglobal.mobile.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidateService {
    public boolean validateString(String input) {
        String regex = "^[a-zA-Z]{1}[a-zA-Z0-9\\s]{3,100}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
