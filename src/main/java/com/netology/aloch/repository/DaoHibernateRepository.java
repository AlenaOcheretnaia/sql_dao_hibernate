package com.netology.aloch.repository;

import com.netology.aloch.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DaoHibernateRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Person p where p.city = :city", Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }
}
