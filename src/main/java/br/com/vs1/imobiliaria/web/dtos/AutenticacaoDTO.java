package br.com.vs1.imobiliaria.web.dtos;

public class AutenticacaoDTO {
    
    private String email;
    
    private String senha;

    private boolean  lembrarEmail;
    
    public AutenticacaoDTO(){}

    public AutenticacaoDTO(String email, String senha, boolean lembrarEmail) {
        this.email = email;
        this.senha = senha;
        this.lembrarEmail = lembrarEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isLembrarEmail() {
        return lembrarEmail;
    }

    public void setLembrarEmail(boolean lembrarEmail) {
        this.lembrarEmail = lembrarEmail;
    }

    @Override
    public String toString() {
        return "AutenticacaoDTO [email=" + email + ", senha=" + senha + ", lembrarEmail=" + lembrarEmail + "]";
    }

    
   

    
}
