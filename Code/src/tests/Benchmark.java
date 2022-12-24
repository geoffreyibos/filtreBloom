package tests;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.Random;
import s3.pkg8_algorithmique.IFiltreBloom;
/**
 *
 * @author gibos
 */
public class Benchmark {
    private IFiltreBloom filtreBloom;
    // Le nombre d'entiers random que l'on ajoute au filtre avec
    // la méthode ajoutElemRandom()
    private ArrayList<Integer> nbRandoms;

    /**
     * Constructeur de la classe Benchmark
     * @param filtre le filtre de Bloom à tester
     */
    public Benchmark(IFiltreBloom filtre) {
        this.filtreBloom = filtre;
        nbRandoms = new ArrayList<>();
    }
    
    /**
     * Ajoute n éléments random entre 0 et 2^12 (exclu) au filtre et à nbRandoms
     * @param n le nombre d'entiers random à ajouter
     */
    public void ajoutElemRandom(int n) {
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int nb = random.nextInt((int)Math.pow(2, 12));
            nbRandoms.add(nb);
            filtreBloom.ajoutElemFiltre(nb);
        }
    }
    
    /**
     * Mesure le temps d'exécution en nanosecondes pour
     * la recherche de n éléments dans le filtre
     * @param m la taille du filtre
     * @param k le nombre de hachages
     * @param n le nombre d'éléments à rechercher
     */
    public void tempsRechercheElem(int m, int k, int n) {
        long tempsMoyen = 0;
        for (int i = 0; i < n; i++) {
            // L'élément à chercher
            int elt = nbRandoms.get(i);
            // Démarrage du chronomètre
            long debut = System.nanoTime();
            // Recherche de l'élément
            filtreBloom.testPresenceElem(elt);
            // Arrêt du chronomètre
            long fin = System.nanoTime();
            tempsMoyen = tempsMoyen + (fin-debut);
        }
        tempsMoyen = tempsMoyen / n;
        // Affiche la durée d'exécution
        System.out.println("Temps moyen d'exécution pour la recherche de " + n + " éléments dans\n"
                + "un filtre de taille " + m + " et avec " + k + " hachages : " + tempsMoyen + " nanosecondes");
    }
    
    /**
     * Calcule le taux d'erreurs du test d'appartenance au filtre
     * @param m la taille du filtre
     * @param k le nombre de hachages
     */
    public void tauxErreur(int m, int k) {
        double n = 0;
        if (k == 1) {
            n = m * 0.01;
        }
        else if (k == 3) {
            n = m * 0.05;
        }
        else {
            n = m * 0.10;
        }
        // On ajoute au moins un élément au filtre
        if (n < 1) {
            n = 1;
        }
        int nbErreurs = 0;
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            // On prend des éléments qui ne sont pas dans le filtre
            int nb = (int)Math.pow(2, 12) + random.nextInt((int)Math.pow(2, 20) - (int)Math.pow(2, 12));
            if (filtreBloom.testPresenceElem(nb)) {
                // Si le filtre se trompe (renvoie true au lieu de false)
                // on augmente de 1 le nombre d'erreurs
                nbErreurs++;
            }
        }
        System.out.println("Le taux d'erreurs du test d'appartenance avec k = "
                + k + ",\nm = " + m + " et n = " + n + " est de " + nbErreurs / n * 100 + " %\n");
    }
    
    /**
     * Getter de l'ArrayList nbRandoms
     * @return nbRandoms
     */
    public ArrayList<Integer> getNbRandoms() {
        return nbRandoms;
    }
    
    /**
     * Getter du filtre de Bloom
     * @return le filtre de Bloom
     */
    public IFiltreBloom getFiltreBloom() {
        return filtreBloom;
    }
    
}
