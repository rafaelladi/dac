package com.dietrich.jakarta2.dao;

import com.dietrich.jakarta2.entity.Company;
import com.dietrich.jakarta2.util.HibernateUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class CompanyDAO {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public boolean save(Company company) {
        boolean result = true;

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        } catch (Exception e) {
            result = false;
            if (transaction != null && transaction.isActive())
                transaction.rollback();
        }

        return result;
    }

    public List<Company> findAll() {
        List<Company> companies;

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            companies = HibernateUtil.listAndCast(session.createQuery("from Company"));

            transaction.commit();
        } catch(Exception e) {
            companies = new ArrayList<>();
            if(transaction != null && transaction.isActive())
                transaction.rollback();
        }

        return companies;
    }
}
