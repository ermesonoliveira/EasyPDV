/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easypdv.teste;

import com.easypdv.DAO.ConexaoJDBC;
import com.easypdv.DAO.GenericDAO;
import com.easypdv.DAO.UsuarioDAO;
import com.easypdv.entidades.Usuario;
import com.easypdv.util.JPAUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ermeson
 */
public class Teste {
      
  
       
    public static void main(String[] args) {
       UsuarioDAO dao = new UsuarioDAO();
       dao.buscar();
       
        
        
    }
    
   
   

    
}
