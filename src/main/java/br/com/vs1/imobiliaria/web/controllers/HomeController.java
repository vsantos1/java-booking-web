package br.com.vs1.imobiliaria.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.vs1.imobiliaria.core.models.Usuario;
import br.com.vs1.imobiliaria.web.dtos.UsuarioDTO;
import br.com.vs1.imobiliaria.web.services.WebImovelService;
import jakarta.validation.Valid;

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


    @GetMapping("/detalhes/imovel/{id}")
    public ModelAndView detalhesImovel(@PathVariable("id") Long id) {

        ModelAndView mv = new ModelAndView("/paginas/detalhe-imovel");

        mv.addObject("imovel", webImovelService.buscarPorId(id));

        return mv;
    }

    @GetMapping("/cadastro")
    public ModelAndView paginaCadastroUsuario(UsuarioDTO usuarioDTO) {

        ModelAndView mv = new ModelAndView("/paginas/cadastro-usuario");
        mv.addObject("form", new Usuario());

        return mv;
    }

    @PostMapping("/cadastro")
    public String cadastroUsuario(@Valid UsuarioDTO usuarioDTO, BindingResult result, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("erro",true);
            System.out.println(result.getAllErrors());
            return "redirect:/cadastro";
        }

        System.out.println(usuarioDTO.toString());
        return "redirect:/entrar";
    }
}