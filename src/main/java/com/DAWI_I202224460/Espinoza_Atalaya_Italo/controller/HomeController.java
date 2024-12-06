package com.DAWI_I202224460.Espinoza_Atalaya_Italo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToMaintenance() {
        return "redirect:/maintenance/start";
    }
}
