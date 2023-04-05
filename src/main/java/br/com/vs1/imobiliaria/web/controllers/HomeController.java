package br.com.vs1.imobiliaria.web.controllers;

import br.com.vs1.imobiliaria.web.dtos.EnderecoDTO;
import br.com.vs1.imobiliaria.web.dtos.FotoDTO;
import br.com.vs1.imobiliaria.web.dtos.ImovelDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.lang.System.in;

@Controller
@RequestMapping("/")
public class HomeController {


    @GetMapping
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("index");

        ArrayList<ImovelDTO> imoveis = new ArrayList<>();

        // TODO: Buscar os imóveis do banco de dados

        EnderecoDTO endereco = new EnderecoDTO("01001-000", "Praça da Sé", "lado ímpar", "São Paulo", "SP", "3550308", "1004", "11", "7107");
        FotoDTO fotoDTO = new FotoDTO("foto1.jpg", 1000L, "image/jpeg", "https://picsum.photos/200/300");

        imoveis.add(new ImovelDTO(1L, "Casa 1", new BigDecimal("100000.00"), new BigDecimal("2000.00"), 100, 3, 2, 1, true, "Casa com 3 quartos, 2 banheiros, 1 vaga de garagem, 100m² de área construída e 100m² de área total.", fotoDTO.getUrl(), endereco, new Date()));
        imoveis.add(new ImovelDTO(2L, "Casa 2", new BigDecimal("200000.00"), new BigDecimal("3000.00"), 200, 4, 3, 2, false, "Casa com 4 quartos, 3 banheiros, 2 vagas de garagem, 200m² de área construída e 200m² de área total.", fotoDTO.getUrl(), endereco, new Date()));
        imoveis.add(new ImovelDTO(3L, "Casa 3", new BigDecimal("300000.00"), new BigDecimal("4000.00"), 300, 5, 4, 3, true, "Casa com 5 quartos, 4 banheiros, 3 vagas de garagem, 300m² de área construída e 300m² de área total.", fotoDTO.getUrl(), endereco, new Date()));
        imoveis.add(new ImovelDTO(4L, "Casa 4", new BigDecimal("400000.00"), new BigDecimal("5000.00"), 400, 6, 5, 4, false, "Casa com 6 quartos, 5 banheiros, 4 vagas de garagem, 400m² de área construída e 400m² de área total.", fotoDTO.getUrl(), endereco, new Date()));
        imoveis.add(new ImovelDTO(5L, "Casa 5", new BigDecimal("500000.00"), new BigDecimal("6000.00"), 500, 7, 6, 5, false, "Casa com 7 quartos, 6 banheiros, 5 vagas de garagem, 500m² de área construída e 500m² de área total.", fotoDTO.getUrl(), endereco, new Date()));
        imoveis.add(new ImovelDTO(6L, "Casa 6", new BigDecimal("600000.00"), new BigDecimal("7000.00"), 600, 8, 7, 6, true, "Casa com 8 quartos, 7 banheiros, 6 vagas de garagem, 600m² de área construída e 600m² de área total.", fotoDTO.getUrl(), endereco, new Date()));


        mv.addObject("imoveis", imoveis);

        return mv;
    }


    @GetMapping("/detalhes/imovel/{id}")
    public ModelAndView test(@PathVariable("id") Long id){

        ModelAndView mv = new ModelAndView("/paginas/detalhe-imovel");
        // TODO: Buscar o imóvel do banco de dados
        ImovelDTO imovel = new ImovelDTO(id, "Casa 1", new BigDecimal("100000.00"), new BigDecimal("2000.00"), 100, 3, 2, 1, false, "Casa com 3 quartos, 2 banheiros, 1 vaga de garagem, 100m² de área construída e 100m² de área total.", "https://picsum.photos/200/300", new EnderecoDTO("01001-000", "Praça da Sé", "lado ímpar", "São Paulo", "SP", "3550308", "1004", "11", "7107"), new Date());

        mv.addObject("imovel", imovel);

        return mv;
    }
}