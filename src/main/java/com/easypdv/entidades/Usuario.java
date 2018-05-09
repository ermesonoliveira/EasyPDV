/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easypdv.entidades;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Ermeson
 */
@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain{

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public EnumPerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(EnumPerfilUsuario perfil) {
        this.perfil = perfil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsaComissao() {
        return usaComissao;
    }

    public void setUsaComissao(String usaComissao) {
        this.usaComissao = usaComissao;
    }

    public Comissao getComissao() {
        return comissao;
    }

    public void setComissao(Comissao comissao) {
        this.comissao = comissao;
    }
    
    private String nome;
    private String cpf;
    private String nascimento;
    private EnumPerfilUsuario perfil;
    private String login;
    private String senha;
    private String usaComissao;
    @OneToMany
    private Comissao comissao;
   
    
}
