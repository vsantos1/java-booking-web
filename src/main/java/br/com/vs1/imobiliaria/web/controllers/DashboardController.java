package br.com.vs1.imobiliaria.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("paginas/dashboard");
    }

    @PostMapping
    public ModelAndView dashboard() {
        return new ModelAndView("paginas/dashboard");
    }
}
