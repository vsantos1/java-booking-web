package br.com.vs1.imobiliaria.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.vs1.imobiliaria.web.dtos.AutenticacaoDTO;

@Controller
public class LoginController {

    @GetMapping("/entrar")
    public ModelAndView login() {

        ModelAndView mv = new ModelAndView("/paginas/login-usuario");

        return mv;
    }

    @GetMapping("/entrar/erro")
    public ModelAndView loginErro() {
        
      
        ModelAndView mv = new ModelAndView("/paginas/login-usuario-erro");

        return mv;
    }

    @GetMapping("/sair")
    public String logout() {
        return "redirect:/";
    }

    // TODO : Implementar o login do usuário
    @PostMapping("/entrar")
    public String loginErro(AutenticacaoDTO autenticacaoDTO) {
        System.out.println(autenticacaoDTO.toString());
        if (!autenticacaoDTO.getEmail().contains("test@gmail.com")) {
            return "redirect:/entrar/erro";
        }

        return "redirect:/";
    }
}