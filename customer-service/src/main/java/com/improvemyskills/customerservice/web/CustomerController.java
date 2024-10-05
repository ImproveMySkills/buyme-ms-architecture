package com.improvemyskills.customerservice.web;

import com.improvemyskills.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RefreshScope
public class CustomerController {

    @Autowired
    private GlobalConfig globalConfig;
    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;
    @GetMapping("/test")
    ResponseEntity<Map> test(){
        System.out.println("It's work !");
        System.out.println("P1 : "+p1);
        System.out.println("P2 : "+p2);
        return new ResponseEntity<>(Map.of("p1", p1, "P2", p2), HttpStatus.OK);
    }

    @GetMapping("/globalConfig")
    ResponseEntity<GlobalConfig> globalConfig(){
        return new ResponseEntity<>(globalConfig, HttpStatus.OK);
    }
}
