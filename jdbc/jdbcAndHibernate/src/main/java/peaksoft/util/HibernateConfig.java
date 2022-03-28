package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import peaksoft.model.User;

import java.util.Properties;

public class HibernateConfig {
    private static SessionFactory session;

    public static SessionFactory getSession(){
        if (session == null){
            try{
                Configuration configuration = new Configuration();

                Properties properties = new Properties();
                properties.put(Environment.DRIVER,"org.postgresql.Driver");
                properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
                properties.put(Environment.USER, "postgres");
                properties.put(Environment.PASS, "google224");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                session = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e){
                e.printStackTrace();

            }
        }
        return session;
    }

}
