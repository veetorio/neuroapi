package com.ceuma.neuroapi.adapters.inbound.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.GetMapping;


@RestController("/")
public class NeuroCatController {

    @GetMapping("/")
    public String getMethodName() {
        return "Seja bem vindo";
    }
    
    
}