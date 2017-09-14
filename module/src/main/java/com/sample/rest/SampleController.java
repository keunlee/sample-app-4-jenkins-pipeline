package com.sample.rest;

import com.sample.model.SimpleResponse;
import com.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @Autowired
    private SampleService sampleService;

    @RequestMapping(value = "/simple", method = {RequestMethod.GET})
    public SimpleResponse getSimpleResponse() {
        return sampleService.getSimpleResponse();
    }
}
