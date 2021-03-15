package fr.cesi.TheMask.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class Persist {
    /**
     * Permet de récupérer l'entity manager pour accéder à la BDD.
     * @return Entity manager
     */
    public static EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("pu").createEntityManager();
    }
}
