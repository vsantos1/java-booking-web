package br.com.vs1.imobiliaria.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.vs1.imobiliaria.web.services.WebImovelService;

@Controller
@RequestMapping("/")
public class HomeController {

    private final WebImovelService webImovelService;

    public HomeController(WebImovelService webImovelService) {
        this.webImovelService = webImovelService;
    }

    @GetMapping
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("index");

        mv.addObject("imoveis", webImovelService.buscarTodosComIntervalo());

        return mv;
    }

    @GetMapping("/tos")
    public ModelAndView tos() {

        return new ModelAndView("/paginas/tos");
    }

}