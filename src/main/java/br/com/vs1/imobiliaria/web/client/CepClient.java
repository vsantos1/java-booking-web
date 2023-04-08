package br.com.vs1.imobiliaria.web.client;

import org.springframework.web.client.RestTemplate;

import br.com.vs1.imobiliaria.core.enums.RequestType;
import br.com.vs1.imobiliaria.web.dtos.EnderecoDTO;

public class CepClient implements CepRequest {

    private String baseUrl = "https://viacep.com.br/ws/";

    private RestTemplate restTemplate;

    public CepClient() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public EnderecoDTO buscarEnderecoPorCep(String cep) {
        EnderecoDTO endereco = restTemplate.getForObject(baseUrl + cep + "/" + RequestType.JSON.getValue(),
                EnderecoDTO.class);

        return endereco;
    }

}
