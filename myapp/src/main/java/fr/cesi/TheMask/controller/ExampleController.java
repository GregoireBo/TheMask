package fr.cesi.TheMask.controller;


import fr.cesi.TheMask.model.Example;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;

@Named
@SessionScoped
public class ExampleController implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int MIN = 100;
    public static final int MAX = 999;
    public static final String TEST_TEXT = "TestText";
    private Example example = new Example();

    /**
     * Permet d'obtenir un objet Example avec des valeurs aléatoires.
     * Le nombre aléatoire sert juste à montrer que c'est dynamique
     */
    public Example getRandomExample() {
        example.setText1("Texte1 | " + (int) MIN + Math.random() * (MAX - MIN));
        example.setText2("Texte2 | " + (int) MIN + Math.random() * (MAX - MIN));

        return example;
    }

    /**
     * Renvoi tous les exemples.
     * @return tableau d'exemple
     */
    public Collection<Example> getAllExample() {
        EntityManager em = Persist.getEntityManager();
        TypedQuery<Example> q =
                em.createQuery("SELECT FROM Example", Example.class);
        return q.getResultList();
    }
}
