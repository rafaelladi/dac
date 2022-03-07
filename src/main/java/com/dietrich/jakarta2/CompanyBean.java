package com.dietrich.jakarta2;

import com.dietrich.jakarta2.dao.CompanyDAO;
import com.dietrich.jakarta2.entity.Company;
import com.dietrich.jakarta2.util.HibernateUtil;
import com.dietrich.jakarta2.util.Pages;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CompanyBean implements Serializable {
    @Inject
    private CompanyDAO companyDAO;
    private List<Company> companies;
    private Company company;

    @PostConstruct
    private void init() {
        this.company = new Company();
        this.companies = companyDAO.findAll();
    }

    public String save() {
        companyDAO.save(this.company);
        return Pages.HOME_REDIRECT;
    }

    public List<Company> loadCompanies() {
        return companyDAO.findAll();
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
