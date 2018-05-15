/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.varejo.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

/**
 *
 * @author Ermeson
 */
public class JPAUtil {
    
    

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("easypdv");
	
	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

    
}
