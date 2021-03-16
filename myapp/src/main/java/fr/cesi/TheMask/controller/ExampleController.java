package fr.cesi.TheMask.controller;


import fr.cesi.TheMask.model.Example;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.Collection;


public class ExampleController extends Persist<Example> implements ControllerInterface<Example>  {


    public static final int MIN = 100;
    public static final int MAX = 999;

    /**
     * Permet d'obtenir un objet Example avec des valeurs aléatoires.
     * Le nombre aléatoire sert juste à montrer que c'est dynamique
     */
    public Example getRandomExample() {
        Example example = new Example();
        example.setText1("Texte1 | " + (int) MIN + Math.random() * (MAX - MIN));
        example.setText2("Texte2 | " + (int) MIN + Math.random() * (MAX - MIN));

        return example;
    }

    @Override
    public Collection<Example> getAll() {
        EntityManager em = getEntityManager();
        TypedQuery<Example> q =
            em.createQuery("SELECT e FROM Example e", Example.class);

        return q.getResultList();
    }

    @Override
    public Example get(final int id) {
        EntityManager em = getEntityManager();
        TypedQuery<Example> q =
            em.createQuery("SELECT e FROM Example e WHERE e.id = ?1", Example.class);
        q.setParameter(1, id);

        return q.getSingleResult();
    }
}
