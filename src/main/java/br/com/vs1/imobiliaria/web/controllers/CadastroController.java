package br.com.vs1.imobiliaria.web.controllers;

import br.com.vs1.imobiliaria.web.dtos.UsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @GetMapping
    public ModelAndView paginaCadastroUsuario(UsuarioDTO usuarioDTO) {

        return new ModelAndView("/paginas/cadastro-usuario");
    }

    @PostMapping
    public ModelAndView cadastroUsuario(@Valid UsuarioDTO usuarioDTO, BindingResult result) {

        if (result.hasErrors()) {

            return new ModelAndView("/paginas/cadastro-usuario");
        }

        System.out.println(usuarioDTO.toString());
        return new ModelAndView("redirect:/");
    }
}
