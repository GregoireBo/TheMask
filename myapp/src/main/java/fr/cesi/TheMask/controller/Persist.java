package fr.cesi.TheMask.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Classe permetant d'effectuer les actions de base d'un controller.
 * @param <T> classe modèle
 */
public class Persist<T> {
    private EntityManager entityManager;
    private List<String> errorMessage;
    private List<String> infoMessage;

    protected void finalize() throws Throwable {
         try {
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructeur de la classe persist, alimente le membre entityManager pour accéder à la base.
     */
    public Persist() {
        this.errorMessage = new ArrayList<String>();
        this.infoMessage = new ArrayList<String>();
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

    public List<String> getErrorMessage() {
        return this.errorMessage;
    }

    public List<String> getInfoMessage() {
        return this.infoMessage;
    }

    protected void addError(final String mess) {
        this.errorMessage.add(mess);
    }

    protected void addInfo(final String mess) {
        this.infoMessage.add(mess);
    }

    protected void clearError() {
        this.errorMessage.clear();
    }

    protected void clearInfo() {
        this.infoMessage.clear();
    }
}
