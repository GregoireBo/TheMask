package fr.cesi.TheMask.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Classe permetant d'effectuer les actions de base d'un controller.
 * @param <T> classe modèle
 */
public class Persist<T> {
    private EntityManager entityManager;


    /**
     * Constructeur de la classe persist, alimente le membre entityManager pour accéder à la base.
     */
    public Persist() {
        this.entityManager = Persistence.createEntityManagerFactory("pu").createEntityManager();
    }

    /**
     * Permet de sauvegarder un élément dans la base de donnée.
     * @param element élément à sauvegarder
     * @return l'élément qui à été sauvegardé
     */
    public T save(final T element) {
        T toReturn;
        this.entityManager.getTransaction().begin();
        toReturn = this.entityManager.merge(element);
        this.entityManager.getTransaction().commit();
        return toReturn;
    }

    /**
     * Permet de récupérer l'entity manager pour accéder à la BDD.
     * @return Entity manager
     */
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
}
