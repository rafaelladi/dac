package com.dietrich.jakarta2.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            System.out.println(session.createQuery("from Company").list().size());

            if(session.getTransaction().isActive())
                session.getTransaction().rollback();
        } catch(Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static <T> List<T> listAndCast(Query q) {
        @SuppressWarnings("unchecked")
        List list = q.list();
        return list;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
