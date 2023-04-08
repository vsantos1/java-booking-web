package br.com.vs1.imobiliaria.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.vs1.imobiliaria.core.models.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long>{

    // Busca todos os imóveis cadastrados nos últimos 7 dias
    @Query(value = "SELECT * FROM tb_imoveis WHERE now() > data_cadastro  - interval '7' day LIMIT 20", nativeQuery = true)
    List<Imovel> buscaLimitada();
}
