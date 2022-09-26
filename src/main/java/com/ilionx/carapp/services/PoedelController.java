package com.ilionx.carapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/poedel")
public class PoedelController {

    @Autowired
    private PoedelService poedelService;

    @GetMapping
    public String onzin() {
        return "Foutje, bedankt";
    }
}
