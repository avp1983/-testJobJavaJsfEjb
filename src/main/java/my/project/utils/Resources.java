/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.project.utils;


import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author www
 */
@Singleton
public class Resources {

    @Produces
    @SecureData
    @PersistenceContext(unitName = "securityData")
    private static EntityManager em;

  
}
