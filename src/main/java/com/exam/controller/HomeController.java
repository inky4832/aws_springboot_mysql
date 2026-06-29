package com.exam.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.http.ResponseEntity;

@Controller
@SessionAttributes(value = {"my_login"})
public class HomeController {


    @GetMapping("/home")
    public String  home(){
        return "home";
    }

    @GetMapping("/health")
    @ResponseBody
    public ResponseEntity<String> healthCheck() {
        try {
            String privateIp = InetAddress.getLocalHost().getHostAddress();
            return ResponseEntity.ok().body(privateIp + " / Success Health Check");
        } catch (UnknownHostException e) {
            return ResponseEntity.ok().body("Unknown Host");
        }
    }

}
