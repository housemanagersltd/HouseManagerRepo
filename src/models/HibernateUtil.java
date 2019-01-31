package models;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            /*ServiceRegistry serviceRegistry
                    = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties()).build();*/

            // builds a session factory from the service registry
            // sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            sessionFactory = configuration.buildSessionFactory();
        }

        return sessionFactory;
    }
}
