/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easypdv.entidades;




/**
 *
 * @author Ermeson
 */

public enum EnumPerfilUsuario{
    ADMINISTRADOR("Administrador"), GERENTE("Gerente"), CAIXA("Caixa");
    
    private String descricao;
    
    private EnumPerfilUsuario(String descricao){
        this.descricao = descricao;
    }
    
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    

   
}
