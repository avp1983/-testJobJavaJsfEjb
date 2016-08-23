/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.project.utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author www
 */
@Singleton
@Startup
public class EntityManagerProducer {

    /*@PersistenceUnit(unitName = "securityData")
    private EntityManagerFactory entityManagerFactory;*/
    @PersistenceContext(unitName = "securityData")
    private EntityManager securityData;

    @Produces
    @SecureData
    public EntityManager create() {
        return securityData; //this.entityManagerFactory.createEntityManager();
    }

    /**
     *
     */
    @PostConstruct
    protected void onStartup() {

    }

    public void dispose(@Disposes EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();

        }

    }

}
