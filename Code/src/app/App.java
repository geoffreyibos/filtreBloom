/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Scanner;
import s3.pkg8_algorithmique.IFiltreBloom;
import s3.pkg8_algorithmique.FiltreBloom_ArrayList;
import s3.pkg8_algorithmique.FiltreBloom_LinkedList;
import s3.pkg8_algorithmique.FiltreBloom_Tableau;
import tests.Benchmark;

/**
 *
 * @author geoff
 */
public class App {
    final private Scanner scanner;
    private IFiltreBloom filtreBloom;
    
    /**
     * Constructeur de la classe App
     */
    public App() {
        scanner = new Scanner(System.in);
    }
    
    /**
     * Lance l'application
     */
    public void run() {
        int val; 
        // La taille du filtre
        int m;
        // Le nombre de hachages
        int k;
        // Le nombre d'éléments à ajouter
        int n;
        boolean fini = false;
        // Menu pour choisir le filtre
        try (scanner) {
            while (!fini) {
                System.out.println("Quelle variante du filtre de Bloom souhaitez-vous utiliser ?\n");
                System.out.println("1.Tableau");
                System.out.println("2.ArrayList");
                System.out.println("3.LinkedList");
                System.out.println("4.Quitter");
                System.out.println("Votre choix [1 - 4]");
                val = scanner.nextInt(); 
                if (val < 1 || val > 4) {
                    System.out.println("Erreur : veuillez entrer une valeur entre 1 et 4.");
                }
                else if (val == 4) {
                    // Quitter
                    fini = true;
                }
                else {
                    System.out.println("Choix des paramètres.\n");
                    System.out.println("Taille du filtre : ");
                    m = scanner.nextInt();
                    System.out.println("Nombre de hachages (1, 3 ou 5) : ");
                    k = scanner.nextInt();
                    if (k != 1 && k != 3 && k != 5) {
                        System.out.println("Le nombre de hachages doit être égal à 1, 3, ou 5");
                        // Quitte le programme
                        break;
                    }
                    System.out.println("Nombre d'éléments à ajouter dans le filtre pour les tests (entre 1 et " + m + ") : ");
                    n = scanner.nextInt();
                    if (n > m || n <= 0) {
                        System.out.println("Nombre d'éléments incorrect");
                        // Quitte le programme
                        break;
                    }
                    if (val == 1) {
                        filtreBloom = new FiltreBloom_Tableau(m, k);
                    }
                    else if (val == 2) {
                        filtreBloom = new FiltreBloom_ArrayList(m, k);
                    }
                    else if (val == 3) {
                        filtreBloom = new FiltreBloom_LinkedList(m, k);
                    }
                    // On initialise un benchmark
                    Benchmark benchmark = new Benchmark(filtreBloom);
                    while (!fini) {
                        System.out.println("Que voulez-vous faire ?\n");
                        System.out.println("1.Afficher le filtre");
                        System.out.println("2.Ajouter un élément");
                        System.out.println("3.Rechercher un élément");
                        System.out.println("4.Supprimer les éléments du filtre (remet tout à false)");
                        System.out.println("5.Tester le temps d'exécution de la recherche d'éléments");
                        System.out.println("6.Tester le taux d'erreurs");
                        System.out.println("7.Quitter");
                        System.out.println("Votre choix [1 - 7]");
                        val = scanner.nextInt();
                        if (val == 1) {
                            System.out.println("Contenu :\n");
                            filtreBloom.afficher();
                        }
                        else if (val == 2) {
                            System.out.println("Élément à ajouter :");
                            val = scanner.nextInt();
                            filtreBloom.ajoutElemFiltre(val);
                            System.out.println(val + " a bien été ajouté.");
                        }
                        else if (val == 3) {
                            System.out.println("Élément à rechercher :");
                            val = scanner.nextInt();
                            System.out.println(filtreBloom.testPresenceElem(val));
                        }
                        else if (val == 4) {
                            supprimerElements(benchmark);
                            System.out.println("Les éléments ont été supprimés");
                        }
                        else if (val == 5) {
                            supprimerElements(benchmark);
                            benchmark.ajoutElemRandom(n);
                            benchmark.tempsRechercheElem(m, k, n);
                            
                        }
                        else if (val == 6) {
                            supprimerElements(benchmark);
                            benchmark.ajoutElemRandom(n);
                            benchmark.tauxErreur(m, k);
                        }
                        else if (val == 7) {
                            // Quitter
                            fini = true;
                        }
                        else {
                            System.out.println("Erreur : veuillez entrer une valeur entre 1 et 7.");
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Vide l'ArrayList nbRandoms et met à false tous les
     * éléments du filtre du benchmark passé en paramètre
     * @param b le benchmark
     */
    public void supprimerElements(Benchmark b) {
        b.getNbRandoms().clear();
        b.getFiltreBloom().supprimerElem();
    }
}
