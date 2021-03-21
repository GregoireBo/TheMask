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

    /**
     * Permet de récupérer un utilisateur depuis un email.
     * @param email de l'utilisateur
     * @return un utilisateur
     */
    public Person getByEmail(final String email) {
        EntityManager em = getEntityManager();
        TypedQuery<Person> q =
            em.createQuery("SELECT p FROM Person p WHERE p.email = ?1", Person.class);
        q.setParameter(1, email);
        if (q.getResultList().isEmpty()) {
            return null;
        } else {
            return q.getSingleResult();
        }
    }

    /**
     * Permet de vérifier la connexion d'un utilisateur.
     * @param person
     * @return un utilisateur ou null
     */
    public Person verifConnection(final Person person) {
        this.clearError();
        this.clearInfo();
        boolean controlOK = true;

        if (person.getEmail() == "") {
            this.addError("L'email est obligatoire");
            controlOK = false;
        }
        if (person.getPassword() == "") {
            this.addError("Le mot de passe est obligatoire");
            controlOK = false;
        }
        if (!controlOK) {
            return null;
        }


        EntityManager em = getEntityManager();
        TypedQuery<Person> q =
            em.createQuery("SELECT p FROM Person p WHERE p.email = ?1 "
                            + "AND p.password = ?2", Person.class);
            q.setParameter(1, person.getEmail());
            q.setParameter(2, person.getPassword());

        if (q.getResultList().isEmpty()) {
            this.addError("L'email et le mot de passe ne correspondent pas");
            return null;
        } else {
            return q.getSingleResult();
        }
    }

    /**
     * Permet d'inscrire un utilisateur après avoir fait tout les controlles nécéssaires.
     * @param person objet utilisateur à enregistrer
     * @return true si réussi, false sinon
     */
    public Person inscript(final Person person) {
        this.clearError();
        this.clearInfo();
        boolean controlOK = true;
        Person personResult = null;

        if (person.getFirstName() == "") {
            this.addError("Le prénom est obligatoire");
            controlOK = false;
        }

        if (person.getLastName() == "") {
            this.addError("Le nom est obligatoire");
            controlOK = false;
        }

        if (person.getEmail() == "") {
            this.addError("L'email est obligatoire");
            controlOK = false;
        } else {
            //on vérifie que l'email n'existe pas seulement s'il est rempli
            if (this.getByEmail(person.getEmail()) != null) {
                this.addError("L'email est déjà utilisé");
                controlOK = false;
            }
        }

        if (person.getPassword() == "") {
            this.addError("Le mot de passe est obligatoire");
            controlOK = false;
        }

        if (controlOK) {
            //Si les controles ont été passés alors on enregistre
            personResult = this.save(person);
            this.addInfo("Enregistrement réussi");
        }

        return personResult;
    }
}
