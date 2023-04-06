package br.com.vs1.imobiliaria.web.controllers;

import br.com.vs1.imobiliaria.web.services.WebImovelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

                mv.addObject("imoveis", webImovelService.buscarTodos());

                return mv;
        }

        @GetMapping("/detalhes/imovel/{id}")
        public ModelAndView test(@PathVariable("id") Long id) {

                ModelAndView mv = new ModelAndView("/paginas/detalhe-imovel");

                mv.addObject("imovel", webImovelService.buscarPorId(id));

                return mv;
        }
}