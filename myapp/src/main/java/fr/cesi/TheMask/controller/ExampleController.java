package fr.cesi.TheMask.controller;

import fr.cesi.TheMask.model.Example;

public abstract class ExampleController {

    private static final int MIN = 100;
    private static final int MAX = 999;

    /**
     * Permet d'obtenir un objet Example avec des valeurs aléatoires.
     * Le nombre aléatoire sert juste à montrer que c'est dynamique
     */
    public static Example getRandomExample() {
        Example oExample = new Example();
        oExample.setText1("Texte1 | " + (int) MIN + Math.random() * (MAX - MIN));
        oExample.setText2("Texte2 | " + (int) MIN + Math.random() * (MAX - MIN));

        return oExample;
    }
}
