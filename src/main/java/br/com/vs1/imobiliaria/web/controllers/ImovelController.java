package br.com.vs1.imobiliaria.web.controllers;

import java.io.IOException;
import java.util.Date;

import br.com.vs1.imobiliaria.web.utils.UsuarioAutenticacao;
import jakarta.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.vs1.imobiliaria.web.dtos.ImovelDTO;
import br.com.vs1.imobiliaria.web.services.WebArquivoUploadService;
import br.com.vs1.imobiliaria.web.services.WebImovelService;
import jakarta.validation.Valid;

@Controller
public class ImovelController {

    private final WebImovelService webImovelService;
    private final WebArquivoUploadService webArquivoUploadService;

    public ImovelController(WebImovelService webImovelService, WebArquivoUploadService webArquivoUploadService) {
        this.webImovelService = webImovelService;

        this.webArquivoUploadService = webArquivoUploadService;
    }

    @GetMapping("/anuncios")
    public ModelAndView imoveis(@RequestParam(required = false) String busca, UsuarioAutenticacao usuarioAutenticacao) {

        ModelAndView mv = new ModelAndView("index");

        if (busca != null && !busca.isEmpty()) {
            return mv.addObject("imoveis", webImovelService.buscarPorParametros(busca));
        }
        mv.addObject("imoveis", webImovelService.buscarTodos());

        return mv;
    }

    @GetMapping("/imoveis/detalhes/{id}")
    public ModelAndView detalhesImovel(@PathVariable("id") Long id, UsuarioAutenticacao usuarioAutenticacao) {

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
    public ModelAndView salvarImovel(@Valid ImovelDTO imovelDTO, BindingResult result) throws IOException {

        if (result.hasErrors()) {
            return new ModelAndView("/paginas/cadastro-imovel");
        }

        imovelDTO.setDataCadastro(new Date());
        if (imovelDTO.getFile().isEmpty()) {
            imovelDTO.setFoto(null);
            webImovelService.salvarImovel(imovelDTO);
            return new ModelAndView("redirect:/");
        }
        String fileName = webArquivoUploadService.imageUpload(imovelDTO.getFile(), "", true, 25);

        imovelDTO.setFoto(fileName);
        imovelDTO.setDataCadastro(new Date());
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

    @GetMapping("/imoveis/excluir/{id}")
    public ModelAndView excluirImovel(@PathVariable("id") Long id) {

        webImovelService.deletarImovel(id);

        return new ModelAndView("redirect:/anuncios");
    }
}
