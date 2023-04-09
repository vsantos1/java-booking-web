package br.com.vs1.imobiliaria.web.controllers;

import br.com.vs1.imobiliaria.core.models.Endereco;
import br.com.vs1.imobiliaria.web.client.CepClient;
import br.com.vs1.imobiliaria.web.dtos.ImovelDTO;
import br.com.vs1.imobiliaria.web.services.WebImovelService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImovelController {

    private final WebImovelService webImovelService;

    public ImovelController(WebImovelService webImovelService) {
        this.webImovelService = webImovelService;

    }

    @GetMapping("/imoveis/detalhes/{id}")
    public ModelAndView detalhesImovel(@PathVariable("id") Long id) {

        ModelAndView mv = new ModelAndView("/paginas/detalhe-imovel");

        mv.addObject("imovel", webImovelService.buscarPorId(id));

        return mv;
    }

    @GetMapping("/imoveis/editar/{id}")
    public ModelAndView editarImovel(@PathVariable("id") Long id, ImovelDTO imovelDTO) {

        ModelAndView mv = new ModelAndView("/paginas/editar-imovel");

        mv.addObject("imovel", webImovelService.buscarPorId(id));

        return mv;
    }

    @GetMapping("/imoveis/novo")
    public ModelAndView novoImovel(ImovelDTO imovelDTO) {


        return new ModelAndView("/paginas/cadastro-imovel");
    }

    @PostMapping("/imoveis/novo")
    public ModelAndView salvarImovel(@Valid ImovelDTO imovelDTO, BindingResult result) {

        if (result.hasErrors()) {
            return new ModelAndView("/paginas/cadastro-imovel");
        }

        webImovelService.salvarImovel(imovelDTO);

        return new ModelAndView("redirect:/");
    }

    @PostMapping("/imoveis/editar/{id}")
    public ModelAndView editarImovel(@PathVariable("id") Long id, @Valid ImovelDTO imovelDTO, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println("erros" + result.getAllErrors());
            ModelAndView mv = new ModelAndView("/paginas/editar-imovel");
            mv.addObject("imovel", webImovelService.buscarPorId(id));
            return mv;
        }

        webImovelService.atualizarImovel(id, imovelDTO);

        return new ModelAndView("redirect:/");
    }
}
