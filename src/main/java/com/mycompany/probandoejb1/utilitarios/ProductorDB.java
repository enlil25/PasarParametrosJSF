/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.probandoejb1.utilitarios;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cesar
 */
public class ProductorDB {
    
    @Produces
    @PersistenceContext(unitName="ejbcap7_pu")
    private EntityManager em;
}
