package fr.cesi.TheMask.controller;

import java.util.Collection;

public interface ControllerInterface<T> {
    /**
     * Permet de récupérer tout les éléments.
     * @return une listé d'éléments
     */
    Collection<T> getAll();

    /**
     * Permet de retourner un élément.
     * @param id de l'élément
     * @return élément trouvé
     */
    T get(int id);
}
