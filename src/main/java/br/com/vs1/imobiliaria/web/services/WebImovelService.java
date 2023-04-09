package br.com.vs1.imobiliaria.web.services;

import br.com.vs1.imobiliaria.core.models.Endereco;
import br.com.vs1.imobiliaria.core.models.Imovel;
import br.com.vs1.imobiliaria.core.repositories.ImovelRepository;
import br.com.vs1.imobiliaria.web.client.CepClient;
import br.com.vs1.imobiliaria.web.dtos.EnderecoDTO;
import br.com.vs1.imobiliaria.web.dtos.ImovelDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WebImovelService {

    private final ImovelRepository imovelRepository;
    private final ModelMapper mapper;
    private final WebEnderecoService webEnderecoService;

    public WebImovelService(ImovelRepository imovelRepository, ModelMapper mapper, WebEnderecoService webEnderecoService) {
        this.imovelRepository = imovelRepository;
        this.mapper = mapper;
        this.webEnderecoService = webEnderecoService;
    }


    public List<Imovel> buscarTodosComIntervalo() {
        return imovelRepository.buscaLimitada();
    }

    public ImovelDTO buscarPorId(Long id) {
        Optional<Imovel> imovel = imovelRepository.findById(id);

        if (imovel.isPresent()) {
            return mapper.map(imovel.get(), ImovelDTO.class);
        }

        // TODO: Tratar exceção
        throw new RuntimeException("Imóvel não encontrado");

    }

    public void salvarImovel(ImovelDTO imovelDTO) {
        Endereco endereco = webEnderecoService.salvarEndereco(mapper.map(imovelDTO.getEndereco(), EnderecoDTO.class));
        imovelDTO.setEndereco(endereco);
        imovelDTO.setDataCadastro(new Date());
        imovelRepository.save(mapper.map(imovelDTO, Imovel.class));
    }

    public void atualizarImovel(Long id, ImovelDTO imovelDTO) {

        ImovelDTO entidade = this.buscarPorId(id);

        imovelDTO.setDataCadastro(entidade.getDataCadastro());

        Imovel imovel = mapper.map(imovelDTO, Imovel.class);

        imovelRepository.save(imovel);

    }

    public void deletarImovel(Long id) {
        ImovelDTO imovel = this.buscarPorId(id);
        imovelRepository.deleteById(imovel.getId());
    }

}
