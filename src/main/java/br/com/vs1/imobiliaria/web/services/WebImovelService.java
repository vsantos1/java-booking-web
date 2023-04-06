package br.com.vs1.imobiliaria.web.services;

import br.com.vs1.imobiliaria.core.models.Imovel;
import br.com.vs1.imobiliaria.core.repositories.ImovelRepository;
import br.com.vs1.imobiliaria.web.dtos.ImovelDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebImovelService {

    private final ImovelRepository imovelRepository;
    private final ModelMapper mapper;

    public WebImovelService(ImovelRepository imovelRepository, ModelMapper mapper) {
        this.imovelRepository = imovelRepository;
        this.mapper = mapper;
    }


    public List<Imovel> buscarTodos() {
        return imovelRepository.findAll();
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
        imovelRepository.save(mapper.map(imovelDTO, Imovel.class));
    }

    public void atualizarImovel(Long id, ImovelDTO imovelDTO) {
        ImovelDTO entidade = this.buscarPorId(id);
        Imovel imovel = mapper.map(imovelDTO, Imovel.class);
        imovelRepository.save(imovel);

    }

    public void deletarImovel(Long id) {
        ImovelDTO imovel = this.buscarPorId(id);
        imovelRepository.deleteById(imovel.getId());
    }

}
