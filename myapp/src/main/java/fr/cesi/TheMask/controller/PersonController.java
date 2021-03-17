package fr.cesi.TheMask.controller;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.cesi.TheMask.model.Person;

public class PersonController extends Persist<Person> implements ControllerInterface<Person>  {

    @Override
    public Collection<Person> getAll() {
        EntityManager em = getEntityManager();
        TypedQuery<Person> q =
            em.createQuery("SELECT p FROM Person p", Person.class);

        return q.getResultList();
    }

    @Override
    public Person get(final int id) {
        EntityManager em = getEntityManager();
        TypedQuery<Person> q =
            em.createQuery("SELECT p FROM Person p WHERE p.id = ?1", Person.class);
        q.setParameter(1, id);

        return q.getSingleResult();
    }
}
