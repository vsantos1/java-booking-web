package br.com.vs1.imobiliaria.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vs1.imobiliaria.core.models.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel, Long>{
}
