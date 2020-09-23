package com.example.demo.controller;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Log
@RestController
public class test {

    @GetMapping("/test")
    public ModelAndView doRequestPythonRest(String sm, int num) {
        log.info("doRequestPythonRest()");

        LinkedList a = new LinkedList();
        a.add(sm);
        a.add(num);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(a);

        // Python Flask 서버에 5000번의 dataServer URL을 요청하는 작업
        String result = restTemplate.getForObject(
                "http://localhost:5000/dataServer",
                String.class
        );

        return null;
    }
}