package br.com.vs1.imobiliaria.web.dtos;

import br.com.vs1.imobiliaria.core.models.Endereco;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public class ImovelDTO {

    private Long id;

    @NotEmpty(message = "O titulo não pode ser vazio")
    private String nome;

    @Min(value = 0, message = "O valor deve ser maior que 0")
    private BigDecimal precoCompra;

    @Min(value = 0, message = "O valor deve ser maior que 0")
    private BigDecimal precoAluguel;

    @Min(value = 0, message = "O valor deve ser maior que 0")
    private Integer tamanho;

    @Min(value = 0, message = "O valor deve ser maior que 0")
    private Integer quantidadeQuartos;

    @Min(value = 0, message = "O valor deve ser maior que 0")
    private Integer quantidadeBanheiros;

    private Integer garagem;

    private boolean disponivel;
    @NotEmpty(message = "A descrição não pode ser vazia")
    private String descricao;
    private String foto;

    private Endereco endereco;
    private Date dataCadastro;

    public ImovelDTO() {
    }

    public ImovelDTO(Long id, String nome, BigDecimal precoCompra, BigDecimal precoAluguel, Integer tamanho, Integer quantidadeQuartos, Integer quantidadeBanheiros, Integer garagem, boolean disponivel, String descricao, String foto, Endereco endereco, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoAluguel = precoAluguel;
        this.tamanho = tamanho;
        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeBanheiros = quantidadeBanheiros;
        this.garagem = garagem;
        this.disponivel = disponivel;
        this.descricao = descricao;
        this.foto = foto;
        this.endereco = endereco;
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(BigDecimal precoCompra) {
        this.precoCompra = precoCompra;
    }

    public BigDecimal getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(BigDecimal precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public Integer getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(Integer quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public Integer getQuantidadeBanheiros() {
        return quantidadeBanheiros;
    }

    public void setQuantidadeBanheiros(Integer quantidadeBanheiros) {
        this.quantidadeBanheiros = quantidadeBanheiros;
    }

    public Integer getGaragem() {
        return garagem;
    }

    public void setGaragem(Integer garagem) {
        this.garagem = garagem;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getfoto() {
        return foto;
    }

    public void setfoto(String foto) {
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "ImovelDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", precoCompra=" + precoCompra +
                ", precoAluguel=" + precoAluguel +
                ", tamanho=" + tamanho +
                ", quantidadeQuartos=" + quantidadeQuartos +
                ", quantidadeBanheiros=" + quantidadeBanheiros +
                ", garagem=" + garagem +
                ", disponivel=" + disponivel +
                ", descricao='" + descricao + '\'' +
                ", foto=" + foto +
                ", endereco=" + endereco +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
