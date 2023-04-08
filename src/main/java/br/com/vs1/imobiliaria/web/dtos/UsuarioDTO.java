package br.com.vs1.imobiliaria.web.dtos;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {
    
    private Long id;

    private String nome;

    @Email
    @NotEmpty
    @NotNull
    private String email;


    @CPF
    private String cpf;

    @Size(min = 6)
    private String senha;

    private String telefone;

    public UsuarioDTO(){}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "UsuarioDTO [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", senha=" + senha
                + ", telefone=" + telefone + "]";
    }

    
    
}
