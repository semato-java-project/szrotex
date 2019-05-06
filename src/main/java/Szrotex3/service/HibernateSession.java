package Szrotex3.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HibernateSession implements ServiceInterface {

    private Session session = null;
    private SessionFactory sessionFactory = null;
    private static HibernateSession instance = null;

    @Autowired
    public HibernateSession() {

        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        this.session = this.sessionFactory.openSession();
    }

    public String getName() {
        return "hibernateSession";
    }

    public Session getSession() {
        return this.session;
    }

}
