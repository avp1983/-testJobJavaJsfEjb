package my.project.startup;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import my.project.entities.security.Users;
import my.project.entities.security.UsersGroups;
import my.project.utils.SecureData;

@Singleton
@Startup
@DependsOn("EntityManagerProducer")
public class ApplicationConfigurationBean {

    //private final Logger log = Logger.getLogger(ApplicationConfigurationBean.class.getName());
    @Inject
    private transient   Logger logger;
    //@Inject
    //@SecureData
    //@PersistenceContext(unitName = "securityData")
    // private EntityManager em;
    
    @Inject
    @SecureData
    private EntityManager em;

    @PostConstruct
    protected void onStartup() {
        logger.info("initializing users and roles..");
        UsersGroups userGroup = new UsersGroups("user", "user");
        em.persist(userGroup);
        userGroup = new UsersGroups("oper", "oper");
        em.persist(userGroup);
        Users user = new Users("oper", "pass");
        em.persist(user);
        user = new Users("user", "pass");
        em.persist(user);

        logger.info("user and roles setup completed");
    }
}
