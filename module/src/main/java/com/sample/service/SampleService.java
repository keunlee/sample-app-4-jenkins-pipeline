package com.sample.service;

import com.sample.model.SimpleResponse;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public SimpleResponse getSimpleResponse() {
        SimpleResponse response = new SimpleResponse();
        response.setMessage("simple response");
        return response;
    }
}
